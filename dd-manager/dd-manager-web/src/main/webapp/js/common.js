
var ddshop = {
    //首页点击选项出现选项卡
    registerMenuEvent:function(){
        //alert("zzzz");
            var $tree=$("#menu .easyui-tree");
            //alert("1111");
            //console.log($tree);
            $tree.tree({
                onClick:function(node){
                    var text=node.text;
                    var href=node.attributes.href;
                    //console.log(text);
                    //console.log(href);
                    if($("#tab").tabs("exists",text)){
                        $("#tab").tabs("select",text);
                    }else{
                        $("#tab").tabs("add",{
                            title:text,
                            href:href,
                            closable:true /*关闭*/
                        });
                    }
                }
            });
    }
}
var itemList ={
    itemListMenuEvent:function () {
        $("#table").datagrid({
            url: "items",
            striped: true,
            pagination: true,
            rownumbers: true,
            fit: true,
            pageSize: 20,//每页显示的记录条数，默认为10
            pageList: [20,50,100],//可以设置每页记录条数的列表
            columns: [[
                {field:'ck',checkbox:true},
                {field: 'id', title: '商品ID',width:100},
                {field: 'title', title: '商品名称',width:300},
                {field: 'statusName', title: '商品状态',width:100},
                {field: 'sellPoint', title: '卖点',width:300},
                {field: 'catName', title: '商品分类',width:100,align:'center'},
                {field: 'price', title: '价格',width:100,align:'right'},
                {field: 'num', title: '库存数量',width:100,align:'right'}
            ]]
        });
    }
}



