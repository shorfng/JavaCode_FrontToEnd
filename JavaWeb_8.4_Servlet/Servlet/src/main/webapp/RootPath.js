/* js获得当前项目的根路径 */

/* 方式1：open方法 */
function getRootPath1(name) {
    var strFullPath = window.document.location.href;
    var strPath = window.document.location.pathname;

    var pos = strFullPath.indexOf(strPath);
    var prePath = strFullPath.substring(0, pos);                                    // 协议//ip地址：端口号
    var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);  // 项目名

    return prePath + postPath + "/" + name;
}

<!-- 方式2：onclick方法 -->
function getRootPath2(name) {
    var strFullPath = window.document.location.href;
    var strPath = window.document.location.pathname;

    var pos = strFullPath.indexOf(strPath);
    var prePath = strFullPath.substring(0, pos);                                    // 协议//ip地址：端口号
    var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);  // 项目名

    // 下面两种都可以
    // window.location.href = (prePath + postPath + "/" + name);
    window.open(prePath + postPath + "/" + name);
}


