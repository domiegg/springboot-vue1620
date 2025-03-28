<template>
<div class="content" :style='{"padding":"30px"}'>
	<div class="text" :style='{"margin":"20px auto","fontSize":"32px","color":"#333","textAlign":"center","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
    <div class="cardView">
        <div class="cards" :style='{"margin":"0 0 20px 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
			<div :style='{"border":"0px solid #ccc","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('gongxiangdanche','首页总数')">
				<div :style='{"borderColor":"#eee","borderRadius":"4px 0px 0px 4px","background":"url(http://codegen.caihongy.cn/20230303/7d7b3d6dd8c54d79b5cbd44a635ecab6.jpg) no-repeat center center / 60% auto","borderWidth":"1px","width":"100px","borderStyle":"solid","height":"100px"}'></div>
				<div :style='{"borderColor":"#eee","alignItems":"center","borderRadius":"0px 4px 4px 0px","flexDirection":"column","background":"#fff","borderWidth":"1px 1px 1px 0","display":"flex","width":"160px","borderStyle":"solid","justifyContent":"center"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"20px","color":"#333","fontWeight":"bold","height":"24px"}'>{{gongxiangdancheCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>共享单车总数</div>
				</div>
			</div>
        </div>
        <div style="display: flex;align-items: center;width: 100%;margin-bottom: 10px;">
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('gongxiangdanche','首页统计')">
                <div id="gongxiangdancheChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('gongxiangdanche','首页统计')">
                <div id="gongxiangdancheChart2" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('gongxiangdanche','首页统计')">
                <div id="gongxiangdancheChart3" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('gongxiangdanche','首页统计')">
                <div id="gongxiangdancheChart4" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('gongxiangdanche','首页统计')">
                <div id="gongxiangdancheChart5" style="width:100%;height:400px;"></div>
            </el-card>
        </div>
    </div>
</div>
</template>
<script>
//5
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
            gongxiangdancheCount: 0,
		};
	},
  mounted(){
    this.init();
    this.getgongxiangdancheCount();
    this.gongxiangdancheChat1();
    this.gongxiangdancheChat2();
    this.gongxiangdancheChat3();
    this.gongxiangdancheChat4();
    this.gongxiangdancheChat5();
  },
  methods:{
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
    },
    getgongxiangdancheCount() {
        this.$http({
            url: `gongxiangdanche/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.gongxiangdancheCount = data.data
            }
        })
    },

    gongxiangdancheChat1() {
      this.$nextTick(()=>{

        var gongxiangdancheChart1 = echarts.init(document.getElementById("gongxiangdancheChart1"),'macarons');
        this.$http({
            url: `gongxiangdanche/value/pp/ridetime`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].pp);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].pp
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: 'pp统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'line',
                        areaStyle: {},
                        smooth: true
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                gongxiangdancheChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    gongxiangdancheChart1.resize();
                };
            }
        });
      })
    },

    gongxiangdancheChat2() {
      this.$nextTick(()=>{

        var gongxiangdancheChart2 = echarts.init(document.getElementById("gongxiangdancheChart2"),'macarons');
        this.$http({
            url: "gongxiangdanche/group/pp",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].pp);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].pp
                    })
                }
                var option = {};
                option = {
                        title: {
                            text: 'pp占比',
                            left: 'center'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: ['25%', '55%'],
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                gongxiangdancheChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    gongxiangdancheChart2.resize();
                };
            }
        });
      })
    },

    gongxiangdancheChat3() {
      this.$nextTick(()=>{

        var gongxiangdancheChart3 = echarts.init(document.getElementById("gongxiangdancheChart3"),'macarons');
        this.$http({
            url: `gongxiangdanche/value/month/ridetime`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].month);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].month
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: 'month统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:70
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                gongxiangdancheChart3.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    gongxiangdancheChart3.resize();
                };
            }
        });
      })
    },


    gongxiangdancheChat4() {
      this.$nextTick(()=>{

        var gongxiangdancheChart4 = echarts.init(document.getElementById("gongxiangdancheChart4"),'macarons');
        this.$http({
            url: "gongxiangdanche/group/area",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].area);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].area
                    })
                }
                var option = {};
                option = {
                        title: {
                            text: 'area占比',
                            left: 'center'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                gongxiangdancheChart4.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    gongxiangdancheChart4.resize();
                };
            }
        });
      })
    },

    gongxiangdancheChat5() {
      this.$nextTick(()=>{

        var gongxiangdancheChart5 = echarts.init(document.getElementById("gongxiangdancheChart5"),'macarons');
        this.$http({
            url: `gongxiangdanche/value/week/ridetime`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].week);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].week
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: 'week统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'value'
                    },
                    yAxis: {
                        type: 'category',
                        data: xAxis
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                gongxiangdancheChart5.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    gongxiangdancheChart5.resize();
                };
            }
        });
      })
    },

  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
</style>
