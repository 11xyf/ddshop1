<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <!-- 自定义脚本 -->
    <script src="js/common.js"></script>
</head>
<body>
<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>商品状态：</label>
        <select id="status" class="easyui-combobox" >
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>
<table id="table"></table>
<!-- 自定义js -->
<script>
    itemList.itemListMenuEvent();
</script>
<script>
    function add() {
        console.log('add');
    }
    function edit(){
        console.log('edit');
    }
    function remove(){
        console.log('remove');
        var selectRows = $("#table").datagrid("getSelections");
        //console.log(selectRows);
        if (selectRows.length == 0) {
            $.messager.alert("警告", "请至少选择一条记录");
            return;
        }
        $.messager.confirm("确认", "确认要删除记录吗？", function (r) {
            if (r) {
                var ids = [];
                for (var i = 0; i < selectRows.length; i++) {
                    ids.push(selectRows[i].id);
                }
                $.post(
                    "items/batchRemove",
                    {"ids[]": ids},
                    function (data) {
                        console.log(data);
                        $("#table").datagrid("reload");
                    },
                    "json"
                );
            }
        })
    }
    function down(){
        console.log('down');
        var selectRows = $("#table").datagrid("getSelections");
        if (selectRows.length == 0) {
            $.messager.alert("警告", "请至少选择一条记录");
            return;
        }
        $.messager.confirm("确认", "确认要下架商品吗？", function (r) {
            if (r) {
                var ids = [];
                for (var i = 0; i < selectRows.length; i++) {
                    if (selectRows[i].status == 1) {
                        ids.push(selectRows[i].id);
                    } else if (selectRows[i].status == 2) {
                        $.messager.alert("错误", "您的选择中含有已下架的商品，请核对后再提交");
                        return;
                    }
                }
                $.post(
                    "items/batchDown",
                    {"ids[]": ids},
                    function (data) {
                        console.log(data);
                        $("#table").datagrid("reload");
                    },
                    "json"
                )
            }
        })
    }

    function up(){
        console.log('up');
        var selectRows = $("#table").datagrid("getSelections");
        if (selectRows.length == 0) {
            $.messager.alert("警告", "请至少选择一条记录");
            return;
        }
        $.messager.confirm("确认", "确认要上架商品吗？", function (r) {
            if (r) {
                var ids = [];
                for (var i = 0; i < selectRows.length; i++) {

                    if (selectRows[i].status == 2) {
                        ids.push(selectRows[i].id);
                    } else if (selectRows[i].status == 1) {
                        $.messager.alert("错误", "您的选择中含有已上架的商品，请核对后再提交");
                        return;
                    }
                }
                $.post(
                    "items/batchUp",
                    {"ids[]": ids},
                    function (data) {
                        console.log(data);
                        $("#table").datagrid("reload");
                    },
                    "json"
                );
            }
        })
    }
    function searchForm(){

        $('#table').datagrid('load',{
            title: $('#title').val(),
            status: $('#status').combobox('getValue')
        });

    }
</script>
</body>
</html>