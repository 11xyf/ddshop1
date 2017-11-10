var ddshop = {
    //首页点击选项出现选项卡
    registerMenuEvent: function () {
        var _this = this;
        var $tree = $("#menu .easyui-tree");
        $tree.tree({
            onClick: function (node) {
                var text = node.text;
                var href = node.attributes.href;
                _this.addTab(text, href);
            }
        });
    },
    addTab: function (text, href) {
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
};
var itemList = {
    itemListMenuEvent: function () {
        $("#table").datagrid({
            url: "items",
            multiSort: true,
            //toolbar: toolbar,
            toolbar: "#toolbar",
            striped: true,
            pagination: true,
            rownumbers: true,
            fit: true,
            pageSize: 20,//每页显示的记录条数，默认为10
            pageList: [20, 50, 100],//可以设置每页记录条数的列表
            columns: [[
                {field: 'ck', checkbox: true},
                {field: 'id', title: '商品ID', sortable: true},
                {field: 'title', title: '商品名称', sortable: true},
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