var stringeeClient;
var fromNumber = 'FROM_YOUR_NUMBER';
var call;
var screenStream;
var isSharingScreen = false;

$(document).ready(function () {
    console.log('StringeeUtil.isWebRTCSupported: ' + StringeeUtil.isWebRTCSupported());

    $('#loginBtn').on('click', function () {
        $('#loggedUserId').html('Connecting...');
        var accessToken = $('#accessTokenArea').val();
        console.log('accessToken...: ' + accessToken);

        stringeeClient = new StringeeClient();
        settingClientEvents(stringeeClient);
        stringeeClient.connect(accessToken);
    });
});

function testAnswerCall() {
    call.answer(function (res) {
        console.log('answer res', res);
        $('#incoming-call-div').hide();
    });
}

function testRejectCall() {
    callEnded();
    call.reject(function (res) {
        console.log('reject res', res);
        $('#incoming-call-div').hide();
    });
}

function testMakeCall(videocall) {
    console.log('make call, videocall: ' + videocall);
    call = new StringeeCall(stringeeClient, fromNumber, $('#callTo').val(), videocall);
    
    settingCallEvent(call);

    if (videocall && screenStream) {
        var videoTracks = screenStream.getVideoTracks();
        if (videoTracks.length > 0) {
            // Thêm track video từ màn hình vào localStream
            call.getLocalStream().addTrack(videoTracks[0]);
            
            // Gửi thông điệp để thông báo việc chia sẻ màn hình
            var customParams = {
                screenSharing: true
            };
            call.custom(customParams);

            // Đặt biến toàn cục để theo dõi trạng thái chia sẻ màn hình
            isSharingScreen = true;
        }
    }

    call.makeCall(function (res) {
        console.log('make call callback: ' + JSON.stringify(res));
    });
}

function settingClientEvents(client) {
    client.on('connect', function () {
        console.log('++++++++++++++ connected to StringeeServer');
    });

    client.on('authen', function (res) {
        console.log('authen', res);
        if (res.r === 0) {
            $('#loggedUserId').html(res.userId);
            $('#loggedUserId').css('color', 'blue');
            $('#callBtn').removeAttr('disabled');
            $('#videoCallBtn').removeAttr('disabled');
        } else {
            $('#loggedUserId').html(res.message);
        }
    });

    client.on('disconnect', function () {
        $('#callBtn').attr('disabled', 'disabled');
        $('#videoCallBtn').attr('disabled', 'disabled');
        console.log('++++++++++++++ disconnected: ' + this.test);
    });

    client.on('incomingcall', function (incomingcall) {
        call = incomingcall;
        settingCallEvent(incomingcall);
        $('#incoming-call-div').show();
        call.ringing(function (res) {});
        console.log('++++++++++++++ incomingcall', incomingcall);
    });

    client.on('requestnewtoken', function () {
        console.log('++++++++++++++ requestnewtoken; please get new access_token from YourServer and call client.connect(new_access_token)+++++++++');
        // please get new access_token from YourServer and call: 
        // client.connect(new_access_token);
    });
}

function settingCallEvent(call1) {
    callStarted();

    call1.on('addlocalstream', function (stream) {
    console.log('addlocalstream');
    localVideo.srcObject = null;
    localVideo.srcObject = stream;

    var videoTracks = stream.getVideoTracks();
    if (videoTracks.length > 0 && call1.remoteStreams.length > 0) {
        call1.remoteStreams[0].addTrack(videoTracks[0]);
    }
});

call1.on('addremotestream', function (stream) {
    console.log('addremotestream');
    remoteVideo.srcObject = null;
    remoteVideo.srcObject = stream;

    // Kiểm tra nếu đang chia sẻ màn hình, ẩn video thông thường
    if (isSharingScreen) {
        localVideo.style.display = 'none';
    } else {
        localVideo.style.display = 'block';
    }
});


    call1.on('error', function (info) {
        console.log('on error: ' + JSON.stringify(info));
    });

    call1.on('signalingstate', function (state) {
        console.log('signalingstate ', state);
        var reason = state.reason;
        $('#callStatus').html(reason);

        if (state.code === 6) { // call Ended
            $('#incoming-call-div').hide();
            callEnded();
        } else if (state.code === 5) { // busy
            callEnded();
        }
    });

    call1.on('mediastate', function (state) {
        console.log('mediastate ', state);
    });

    call1.on('info', function (info) {
        console.log('on info:' + JSON.stringify(info));
    });

    call1.on('otherdevice', function (data) {
        console.log('on otherdevice:' + JSON.stringify(data));
        if ((data.type === 'CALL_STATE' && data.code >= 200) || data.type === 'CALL_END') {
            $('#incoming-call-div').hide();
            callEnded();
        }
    });
}

function testHangupCall() {
    remoteVideo.srcObject = null;
    callEnded();
    call.hangup(function (res) {
        console.log('hangup res', res);
    });
}

function mute() {
    var muted = !call.muted;
    call.mute(muted);

    if (muted) {
        $('#muteBtn').html('Unmute');
    } else {
        $('#muteBtn').html('Mute');
    }
}

function enableVideo() {
    var success;
    if (call.localVideoEnabled) {
        success = call.enableLocalVideo(false);
    } else {
        success = call.enableLocalVideo(true);
    }
    console.log('enableVideo result: ' + success);
}

function callStarted() {
    $('#hangupBtn').removeAttr('disabled');
    $('#upgradeToVideoCallBtn').removeAttr('disabled');
    $('#switchVoiceVideoBtn').removeAttr('disabled');
    $('#muteBtn').removeAttr('disabled');
    $('#enableVideoBtn').removeAttr('disabled');
}

function callEnded() {
    $('#hangupBtn').attr('disabled', 'disabled');
    $('#upgradeToVideoCallBtn').attr('disabled', 'disabled');
    $('#switchVoiceVideoBtn').attr('disabled', 'disabled');
    $('#muteBtn').attr('disabled', 'disabled');
    $('#enableVideoBtn').attr('disabled', 'disabled');

    setTimeout(function () {
        $('#callStatus').html('Call ended');
    }, 1500);
}
