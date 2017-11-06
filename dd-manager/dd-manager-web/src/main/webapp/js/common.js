
var ddshop = {
    //首页点击选项出现选项卡
    registerMenuEvent:function(){
        //alert("zzzz");
        $(function () {
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
        });
    }
}
var itemList ={
    itemListMenuEvent:function () {
        $("#table").datagrid({
            url: 'items',
            columns: [[
                {field: 'id', title: '商品ID'},
                {field: 'title', title: '商品名称'},
                {field: 'sellPoint', title: '卖点'},
                {field: 'price', title: '价格'},
                {field: 'num', title: '库存数量'}
            ]]
        });
    }
}



