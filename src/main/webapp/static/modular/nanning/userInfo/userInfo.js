/**
 * 用户信息管理初始化
 */
var UserInfo = {
    id: "UserInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
UserInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
    ];
};

/**
 * 检查是否选中
 */
UserInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        UserInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加用户信息
 */
UserInfo.openAddUserInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加用户信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/userInfo/userInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看用户信息详情
 */
UserInfo.openUserInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '用户信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/userInfo/userInfo_update/' + UserInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除用户信息
 */
UserInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/userInfo/delete", function (data) {
            Feng.success("删除成功!");
            UserInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("userInfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询用户信息列表
 */
UserInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    UserInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = UserInfo.initColumn();
    var table = new BSTable(UserInfo.id, "/userInfo/list", defaultColunms);
    table.setPaginationType("client");
    UserInfo.table = table.init();
});
