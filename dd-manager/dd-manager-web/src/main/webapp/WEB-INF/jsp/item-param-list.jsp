<%--
  User: Administrator
  Date: 2017/11/13
  Time: 20:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script src="js/common.js"></script>
</head>
<body>
<div id="paramToolbar">
    <div>
        <button type="button" onclick="addParam()" class="easyui-linkbutton"
                data-options="iconCls:'icon-add',plain:true">新增
        </button>
        <button type="button" onclick="editParam()" class="easyui-linkbutton"
                data-options="iconCls:'icon-edit',plain:true">编辑
        </button>
        <button type="button" onclick="deleteParam()" class="easyui-linkbutton"
                data-options="iconCls:'icon-cancel',plain:true">删除
        </button>
    </div>
</div>
<table id="tableParam"></table>

<script>

    itemParamList.itemParamListMenuEvent();

    function addParam() {

        ddshop.addTab('新增商品规格模板', 'item-param-add');
    }

    function editParam() {

    }

    function deleteParam() {
        //ddshop.executeOperation('未选中商品规格模板!', '确定删除所选商品规格模板吗？', 'item/param/delete?');
    }
</script>
</body>
</html>
