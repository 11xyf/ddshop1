var ddshop = {
    //首页点击选项出现选项卡
    registerMenuEvent: function () {
        //alert("zzzz");
        var $tree = $("#menu .easyui-tree");
        //alert("1111");
        //console.log($tree);
        $tree.tree({
            onClick: function (node) {
                var text = node.text;
                var href = node.attributes.href;
                //console.log(text);
                //console.log(href);
                if ($("#tab").tabs("exists", text)) {
                    $("#tab").tabs("select", text);
                } else {
                    $("#tab").tabs("add", {
                        title: text,
                        href: href,
                        closable: true /*关闭*/
                    });
                }
            }
        });
    }
};
var toolbar = [{
    iconCls: 'icon-add',
    text: '新增',
    handler: function () {
        console.log('add');
    }
}, {
    iconCls: 'icon-remove',
    text: '删除',
    handler: function () {
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
                //console.log(ids);
                /* $.ajax({
                     url:"items/batchRemove",
                     data:{"ids[]":ids},
                     dataType:"json",
                     type:"post",
                     success:function (data) {
                         console.log(data);
                         $("#table").datagrid("reload");
                     },
                     error:function () {
                         alert("服务器异常");
                     }
                 })*/
            }
        })
    }
}, {
    iconCls: 'icon-edit',
    text: '编辑',
    handler: function () {
        console.log('edit');
    }
}, {
    iconCls: 'icon-up',
    text: '上架',
    handler: function () {
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
                /*              $.ajax({
                                 url:"items/batchUp",
                                 data:{"ids[]":ids},
                                 dataType:"json",
                                 type:"post",
                                 success:function (data) {
                                     console.log(data);
                                     $("#table").datagrid("reload");
                                 },
                                  error:function () {
                                      alert("服务器异常");
                                  }
                              })*/

            }
        })
    }
}, {
    iconCls: 'icon-down',
    text: '下架',
    handler: function () {
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
                /*$.ajax({
                    url:"items/batchDown",
                    data:{"ids[]":ids},
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        console.log(data);
                        $("#table").datagrid("reload");
                    },
                    error:function () {
                        alert("服务器异常");
                    }
                })*/
            }
        })
    }
}];
var itemList = {
    itemListMenuEvent: function () {
        $("#table").datagrid({
            url: "items",
            toolbar: toolbar,
            striped: true,
            pagination: true,
            rownumbers: true,
            fit: true,
            pageSize: 20,//每页显示的记录条数，默认为10
            pageList: [20, 50, 100],//可以设置每页记录条数的列表
            columns: [[
                {field: 'ck', checkbox: true},
                {field: 'id', title: '商品ID'},
                {field: 'title', title: '商品名称'},
                {field: 'sellPoint', title: '卖点'},
                {field: 'statusName', title: '商品状态'},
                {field: 'catName', title: '商品分类'},
                {field: 'priceView', title: '商品价格'},
                {
                    field: 'created', title: '创建时间', formatter: function (value, row, index) {
                    /*console.group();
                    console.log(value);
                    console.log(row);
                    console.log(index);
                    console.groupEnd();*/
                    return moment(value).format("LLL");
                }
                },
                {
                    field: 'updated', title: '更新时间', formatter: function (value, row, index) {
                    return moment(value).format("LLL");
                }
                },
            ]]
        });

    }
}