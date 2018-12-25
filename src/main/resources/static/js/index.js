$(function (){
    var E = window.wangEditor
    var editor = new E('#divDemo')
    editor.customConfig.uploadImgShowBase64 = true
    editor.create()
});