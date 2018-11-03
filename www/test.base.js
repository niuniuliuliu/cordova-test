var exec = require('cordova/exec');

module.exports = {
    toastWithCallback: function (content, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "ToastDemo", "toastWithCallback", [content]);
    }
};