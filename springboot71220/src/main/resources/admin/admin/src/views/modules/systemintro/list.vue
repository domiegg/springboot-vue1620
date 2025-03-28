<template>
	<div class="main-content" :style='{"padding":"0px"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"margin":"0 0 20px"}' :inline="true" :model="searchForm">
				<el-row :style='{"padding":"20px 30px","borderColor":"#565656 #4d4d4d #aaa","borderStyle":"solid","background":"","borderWidth":"0px 0px 0px 0","display":"block"}' >
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 12px 0 0","color":"#aaa","display":"inline-block","lineHeight":"40px","fontSize":"16px","fontWeight":"500","height":"40px"}' class="item-label">标题</label>
						<el-input v-model="searchForm.title" placeholder="标题" clearable></el-input>
					</div>
					<el-button :style='{"border":"1px solid #ccc","cursor":"pointer","padding":"0 30px","outline":"none","margin":"0 0 0 20px","color":"#333","borderRadius":"5px","background":"url(http://codegen.caihongy.cn/20221012/95d5965bc91d4dcc85b75f7ae3f3b580.png) no-repeat 10px 10px,-webkit-linear-gradient(top,#ffffff,#e6e6e6)","width":"auto","fontSize":"14px","height":"38px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"padding":"0 30px","margin":"20px 0","display":"flex"}'>
					<el-button :style='{"border":"1px solid #113355","cursor":"pointer","padding":"0 24px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#446688,#113355)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('systemintro','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"1px solid #b40b0c","cursor":"pointer","padding":"0 24px","margin":"0 10px 0 0","outline":"none","color":"#fff","borderRadius":"2px","background":"-webkit-linear-gradient(top,#e23738,#ca1112)","width":"auto","fontSize":"14px","height":"30px"}' v-if="isAuth('systemintro','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>




				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","borderColor":"#eee","margin":"0 30px","borderRadius":"5px","borderWidth":"1px 0px 0px 1px","background":"url(http://codegen.caihongy.cn/20221014/f2c15076134a442098a4bc3bbe364575.png)","width":"calc(100% - 60px)","borderStyle":"solid"}' 
					v-if="isAuth('systemintro','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="索引" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="title"
					label="标题">
						<template slot-scope="scope">
							{{scope.row.title}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="subtitle"
					label="副标题">
						<template slot-scope="scope">
							{{scope.row.subtitle}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="picture1" width="200" label="图片1">
						<template slot-scope="scope">
							<div v-if="scope.row.picture1">
								<img v-if="scope.row.picture1.substring(0,4)=='http'" :src="scope.row.picture1.split(',')[0]" width="100" height="100">
								<img v-else :src="$base.url+scope.row.picture1.split(',')[0]" width="100" height="100">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="picture2" width="200" label="图片2">
						<template slot-scope="scope">
							<div v-if="scope.row.picture2">
								<img v-if="scope.row.picture2.substring(0,4)=='http'" :src="scope.row.picture2.split(',')[0]" width="100" height="100">
								<img v-else :src="$base.url+scope.row.picture2.split(',')[0]" width="100" height="100">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="picture3" width="200" label="图片3">
						<template slot-scope="scope">
							<div v-if="scope.row.picture3">
								<img v-if="scope.row.picture3.substring(0,4)=='http'" :src="scope.row.picture3.split(',')[0]" width="100" height="100">
								<img v-else :src="$base.url+scope.row.picture3.split(',')[0]" width="100" height="100">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"1px solid #3ca512","cursor":"pointer","padding":"0 14px","margin":"3px 6px 3px 0","outline":"none","color":"#fff","borderRadius":"4px","background":"-webkit-linear-gradient(top,#8ad96b,#41b314)","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('systemintro','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"1px solid #409eff","cursor":"pointer","padding":"0 14px","margin":"3px 6px 3px 0","outline":"none","color":"#fff","borderRadius":"4px","background":"-webkit-linear-gradient(top,#81b5ea,#2e89e6)","width":"auto","fontSize":"14px","height":"32px"}' v-if=" isAuth('systemintro','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"border":"1px solid #c01515","cursor":"pointer","padding":"0 14px","margin":"3px 6px 3px 0","outline":"none","color":"#fff","borderRadius":"4px","background":"-webkit-linear-gradient(top,#de6464,#db2222)","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('systemintro','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
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





	</div>
</template>

<script>
//$graphType1
//$buttonName1
//$subNameList1
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
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      layouts: ["total","prev","pager","next","sizes","jumper"],

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
           if(this.searchForm.title!='' && this.searchForm.title!=undefined){
            params['title'] = '%' + this.searchForm.title + '%'
          }
      this.$http({
        url: "systemintro/page",
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
          url: "systemintro/delete",
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
