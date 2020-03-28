var user = {

}
Vue.filter('dateFormat',function(msg){
    //字符串的replace方法,第一参数,除了可写一个字符串,还可以定义一个正则
    var date=new Date(msg);
    var year = date.getFullYear().toString();
    var month = date.getMonth()+1;
    if(month<10){
        month = "0"+month.toString();
    }
    var day  = date.getDate();
    if(day<10){
        day = "0"+day.toString();
    }
    var format=year+"-"+month+"-"+day;
    return format;
})

Vue.filter('sexFormat',function(msg){
    var sex;
    if(msg==1){
        sex = '男';
    }else if(msg==2){
        sex = '女';
    }else{
        sex = '未设置';
    }

    return sex;
})
Vue.filter('departFormat',function(msg){

    var depart;
    if(msg==1){
        depart='经理';
    }else if(msg==3){
        depart='人事部';
    }else if(msg==4){
        depart='采购部';
    }else if(msg==5){
        depart='物资部';
    }else if(msg==6){
        depart='销售部';
    }else{
        depart="未设置";
    }
    return depart;


})




var vm = new Vue({
    el:"#user_formation",
    data:{
        user:user


    },
    methods:{

    },
    created:function(){


        this.$http.get('../../user/getUserSession')
            .then(
                function(response){

                    console.log(response.body);
                    this.user=response.body.user;

                    layui.use('layer',function(){
                        var layer = layui.layer;

                        layer.msg("恭喜登录成功");

                    });

                },
                function(){
                    alert("发送请求失败");
                }
            );

    },


})



