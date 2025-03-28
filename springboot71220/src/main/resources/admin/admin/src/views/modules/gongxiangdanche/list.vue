<template>
	<div class="main-content" :style='{"padding":"0px"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"margin":"0 0 20px"}' :inline="true" :model="searchForm">
				<el-row :style='{"padding":"20px 30px","borderColor":"#565656 #4d4d4d #aaa","borderStyle":"solid","background":"","borderWidth":"0px 0px 0px 0","display":"block"}' >
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 12px 0 0","color":"#aaa","display":"inline-block","lineHeight":"40px","fontSize":"16px","fontWeight":"500","height":"40px"}' class="item-label">pp</label>
						<el-input v-model="searchForm.pp" placeholder="pp" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 12px 0 0","color":"#aaa","display":"inline-block","lineHeight":"40px","fontSize":"16px","fontWeight":"500","height":"40px"}' class="item-label">area</label>
						<el-input v-model="searchForm.area" placeholder="area" clearable></el-input>
					</div>
					<el-button :style='{"border":"1px solid #ccc","cursor":"pointer","padding":"0 30px","outline":"none","margin":"0 0 0 20px","color":"#333","borderRadius":"5px","background":"url(http://codegen.caihongy.cn/20221012/95d5965bc91d4dcc85b75f7ae3f3b580.png) no-repeat 10px 10px,-webkit-linear-gradient(top,#ffffff,#e6e6e6)","width":"auto","fontSize":"14px","height":"38px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"padding":"0 30px","margin":"20px 0","display":"flex"}'>
					<el-button :style='{"border":"1px solid #113355","cursor":"pointer","padding":"0 24px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#446688,#113355)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"1px solid #b40b0c","cursor":"pointer","padding":"0 24px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#e23738,#ca1112)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>

					<el-button :style='{"border":"1px solid #e37e18","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#f1973c,#da6e01)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','导入')" type="success" @click="importHandler()">导入</el-button>
                    <el-button :style='{"border":"1px solid #e37e18","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#f1973c,#da6e01)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','导入')" type="success" @click="importClcik">上传模板</el-button>
                    <el-button :style='{"border":"1px solid #e37e18","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#f1973c,#da6e01)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','导入')" type="success" @click="download($base.url + 'upload/gongxiangdanche_template.xlsx')">下载模板</el-button>


					<download-excel v-if="isAuth('gongxiangdanche','导出')" class="export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "共享单车.xls">
						<!-- 导出excel -->
						<el-button :style='{"border":"1px solid #e37e18","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#f1973c,#da6e01)","width":"auto","fontSize":"14px","height":"30px"}' type="danger">导出</el-button>
					</download-excel>


					<el-button :style='{"border":"1px solid #e37e18","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#f1973c,#da6e01)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','pp统计')" type="warning" @click="chartDialog1()">pp统计</el-button>
					<el-button :style='{"border":"1px solid #e37e18","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#f1973c,#da6e01)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','pp占比')" type="warning" @click="chartDialog2()">pp占比</el-button>
					<el-button :style='{"border":"1px solid #e37e18","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#f1973c,#da6e01)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','month统计')" type="warning" @click="chartDialog3()">month统计</el-button>
					<el-button :style='{"border":"1px solid #e37e18","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#f1973c,#da6e01)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','area占比')" type="warning" @click="chartDialog4()">area占比</el-button>
					<el-button :style='{"border":"1px solid #e37e18","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#f1973c,#da6e01)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('gongxiangdanche','week统计')" type="warning" @click="chartDialog5()">week统计</el-button>
				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","borderColor":"#eee","margin":"0 30px","borderRadius":"5px","borderWidth":"1px 0px 0px 1px","background":"url(http://codegen.caihongy.cn/20221014/f2c15076134a442098a4bc3bbe364575.png)","width":"calc(100% - 60px)","borderStyle":"solid"}' 
					v-if="isAuth('gongxiangdanche','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="索引" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="bid"
					label="bid">
						<template slot-scope="scope">
							{{scope.row.bid}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="account"
					label="account">
						<template slot-scope="scope">
							{{scope.row.account}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="pp"
					label="pp">
						<template slot-scope="scope">
							{{scope.row.pp}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="month"
					label="month">
						<template slot-scope="scope">
							{{scope.row.month}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="orderid"
					label="orderid">
						<template slot-scope="scope">
							{{scope.row.orderid}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="area"
					label="area">
						<template slot-scope="scope">
							{{scope.row.area}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="price"
					label="price">
						<template slot-scope="scope">
							{{scope.row.price}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="ridetime"
					label="ridetime">
						<template slot-scope="scope">
							{{scope.row.ridetime}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="starttime"
					label="starttime">
						<template slot-scope="scope">
							{{scope.row.starttime}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="week"
					label="week">
						<template slot-scope="scope">
							{{scope.row.week}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"1px solid #3ca512","cursor":"pointer","padding":"0 14px","margin":"3px 6px 3px 0","outline":"none","color":"#fff","borderRadius":"4px","background":"-webkit-linear-gradient(top,#8ad96b,#41b314)","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('gongxiangdanche','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"1px solid #409eff","cursor":"pointer","padding":"0 14px","margin":"3px 6px 3px 0","outline":"none","color":"#fff","borderRadius":"4px","background":"-webkit-linear-gradient(top,#81b5ea,#2e89e6)","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('gongxiangdanche','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"border":"1px solid #c01515","cursor":"pointer","padding":"0 14px","margin":"3px 6px 3px 0","outline":"none","color":"#fff","borderRadius":"4px","background":"-webkit-linear-gradient(top,#de6464,#db2222)","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('gongxiangdanche','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="上一页"
					next-text="下一页"
					:hide-on-single-page="true"
					:style='{"width":"100%","padding":"0 30px 20px","margin":"20px 0 0","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
				></el-pagination>
			<!-- </div> -->
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>



		<el-dialog title="导入" :visible.sync="importVisiable" width="50%">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item class="upload" label="文件" prop="excelFile">
				  <excel-file-upload
				  tip="点击上传直接导入excel文件"
				  action="gongxiangdanche/importExcel"
				  :limit="1"
                  @change="importChange"
				  ></excel-file-upload>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="importHandler()">关 闭</el-button>
			</span>
		</el-dialog>
        <el-dialog title="上传模板" :visible.sync="importVis" width="50%">
            <el-form ref="form" :model="importForm" label-width="80px">
                <el-form-item class="upload" label="文件" prop="excelFile">
                    <el-upload class="upload-demo" drag :action="$base.url + 'file/upload?type=gongxiangdanche_template'"
                        :show-file-list="false" :on-success="importSuccess">
                        <i class="el-icon-upload"></i>
                        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                    </el-upload>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="importVis=false">关 闭</el-button>
            </span>
        </el-dialog>


		<el-dialog
		  title="pp统计"
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="ridetimeChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>
		<el-dialog
		  title="pp占比"
		  :visible.sync="chartVisiable2"
		  width="800">
			<div id="ppChart2" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog2">返回</el-button>
		  </span>
		</el-dialog>
		<el-dialog
		  title="month统计"
		  :visible.sync="chartVisiable3"
		  width="800">
			<div id="ridetimeChart3" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog3">返回</el-button>
		  </span>
		</el-dialog>
		<el-dialog
		  title="area占比"
		  :visible.sync="chartVisiable4"
		  width="800">
			<div id="areaChart4" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog4">返回</el-button>
		  </span>
		</el-dialog>
		<el-dialog
		  title="week统计"
		  :visible.sync="chartVisiable5"
		  width="800">
			<div id="ridetimeChart5" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog5">返回</el-button>
		  </span>
		</el-dialog>
	</div>
</template>

<script>
//折滑面
//pp统计
//[]
import * as echarts from 'echarts'
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      importVisiable: false,
      importVis: false,
      importForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      layouts: ["total","prev","pager","next","sizes","jumper"],
//导出excel
      json_fields: {
      "bid": "bid",    //常规字段
      "account": "account",    //常规字段
      "pp": "pp",    //常规字段
      "month": "month",    //常规字段
      "orderid": "orderid",    //常规字段
      "area": "area",    //常规字段
      "price": "price",    //常规字段
      "ridetime": "ridetime",    //常规字段
      "starttime": "starttime",    //常规字段
      "userid": "userid",    //常规字段
      "week": "week",    //常规字段
      },
      json_meta: [
        [
          {
            " key ": " charset ",
            " value ": " utf- 8 "
          }
        ]
      ],

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },



//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{

        var ridetimeChart1 = echarts.init(document.getElementById("ridetimeChart1"),'macarons');
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
                ridetimeChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    ridetimeChart1.resize();
                };
            }
        });
      })
    },

//统计接口
    chartDialog2() {
      this.chartVisiable2 = !this.chartVisiable2;
      this.$nextTick(()=>{

        var ppChart2 = echarts.init(document.getElementById("ppChart2"),'macarons');
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
                        legend: {
                          orient: 'vertical',
                          left: 'left'
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
                ppChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    ppChart2.resize();
                };
            }
        });
      })
    },

//统计接口
    chartDialog3() {
      this.chartVisiable3 = !this.chartVisiable3;
      this.$nextTick(()=>{
        // month month
        //  ridetime

        var ridetimeChart3 = echarts.init(document.getElementById("ridetimeChart3"),'macarons');
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
                ridetimeChart3.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    ridetimeChart3.resize();
                };
            }
        });
      })
    },

//统计接口
    chartDialog4() {
      this.chartVisiable4 = !this.chartVisiable4;
      this.$nextTick(()=>{

        var areaChart4 = echarts.init(document.getElementById("areaChart4"),'macarons');
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
                        legend: {
                          orient: 'vertical',
                          left: 'left'
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
                areaChart4.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    areaChart4.resize();
                };
            }
        });
      })
    },

//统计接口
    chartDialog5() {
      this.chartVisiable5 = !this.chartVisiable5;
      this.$nextTick(()=>{
        //  ridetime
        // week week

        var ridetimeChart5 = echarts.init(document.getElementById("ridetimeChart5"),'macarons');
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
                ridetimeChart5.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    ridetimeChart5.resize();
                };
            }
        });
      })
    },

    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.pp!='' && this.searchForm.pp!=undefined){
            params['pp'] = '%' + this.searchForm.pp + '%'
          }
           if(this.searchForm.area!='' && this.searchForm.area!=undefined){
            params['area'] = '%' + this.searchForm.area + '%'
          }
      this.$http({
        url: "gongxiangdanche/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    importChange(){
        this.importHandler()
        this.getDataList()
    },
    importClcik() {
        this.importVis = true
    },
    importSuccess(e) {
        if(e.code==0){
            this.$message.success('上传成功');
            this.importVis = false
            
        }
    },
    importHandler() {
        this.importVisiable = !this.importVisiable;
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "gongxiangdanche/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
	//导出excel
	.export-excel-wrapper{
		display: inline-block;
	}
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 0 30px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #ccc;
				background: url(http://codegen.caihongy.cn/20221013/6bd819137d694439900000865d983ab6.png) no-repeat;
				width: 230px;
				font-size: 14px;
				height: 44px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 0 30px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #ccc;
				background: url(http://codegen.caihongy.cn/20221013/6bd819137d694439900000865d983ab6.png) no-repeat;
				width: 230px;
				font-size: 14px;
				height: 44px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 0px solid #ccc;
				border-radius: 0px;
				padding: 0 10px 0 30px;
				box-shadow: 0 0 0px rgba(64, 158, 255, .5);
				outline: none;
				color: #ccc;
				background: url(http://codegen.caihongy.cn/20221013/6bd819137d694439900000865d983ab6.png) no-repeat;
				width: 230px;
				font-size: 14px;
				height: 44px;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: linear-gradient(180deg, rgba(238,238,238,1) 0%, rgba(255,255,255,1) 53%, rgba(238,238,238,1) 100%);
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				color: #333;
				background: none;
				border-color: #eee;
				border-width: 0 0px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				border: 1px solid #ccc;
				color: #333;
				background: none;
				border-color: #999;
				border-width: 0 0px 1px 0;
				border-style: solid;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #333;
				background: none;
				border-color: #eee;
				border-width: 0 0px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 12px 0;
				color: #333;
				background: #eee;
				border-color: #eee;
				border-width: 0 0px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 12px 0;
				color: #333;
				background: none;
				border-color: #eee;
				border-width: 0 0px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #aaa;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				padding: 0 5px;
				margin: 0 3px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				border-color: #ddd;
				line-height: 28px;
				border-radius: 2px;
				background: #fff;
				border-width: 1px;
				border-style: solid;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				padding: 0 5px;
				margin: 0 3px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				border-color: #ddd;
				line-height: 28px;
				border-radius: 2px;
				background: #fff;
				border-width: 1px 1px 1px 1px;
				border-style: solid;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				padding: 0 5px;
				margin: 0 5px;
				color: #C0C4CC;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				border-color: #ddd;
				line-height: 28px;
				border-radius: 3px;
				background: #fff;
				border-width: 1px 1px 1px 1px;
				border-style: solid;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				padding: 0 5px;
				margin: 0 5px;
				color: #C0C4CC;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				border-color: #ddd;
				line-height: 28px;
				border-radius: 3px;
				background: #fff;
				border-width: 1px 1px 1px 1px;
				border-style: solid;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				border-radius: 3px;
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 1px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				background: #fff;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 1px;
				color: #9212fe;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				background: #f5f5f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 1px;
				color: #9212fe;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				background: #f5f5f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				margin: 0 0 0 15px;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 13px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 10px;
				color: #aaa;
				display: inline-block;
				vertical-align: top;
				font-size: 13px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 14px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 14px;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
</style>
