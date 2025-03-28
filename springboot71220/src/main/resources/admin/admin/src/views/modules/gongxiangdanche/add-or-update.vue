<template>
	<div class="addEdit-block" :style='{"padding":"0px"}' style="width: 100%;">
		<el-form
			:style='{"padding":"30px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","margin":"22px","borderRadius":"8px","background":"rgba(255,255,255,.9)"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="80px"
		>
			<template >
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="bid" prop="bid">
					<el-input v-model="ruleForm.bid" placeholder="bid" clearable  :readonly="ro.bid"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="bid" prop="bid">
					<el-input v-model="ruleForm.bid" placeholder="bid" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="account" prop="account">
					<el-input v-model="ruleForm.account" placeholder="account" clearable  :readonly="ro.account"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="account" prop="account">
					<el-input v-model="ruleForm.account" placeholder="account" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="pp" prop="pp">
					<el-input v-model="ruleForm.pp" placeholder="pp" clearable  :readonly="ro.pp"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="pp" prop="pp">
					<el-input v-model="ruleForm.pp" placeholder="pp" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="month" prop="month">
					<el-input v-model="ruleForm.month" placeholder="month" clearable  :readonly="ro.month"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="month" prop="month">
					<el-input v-model="ruleForm.month" placeholder="month" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="orderid" prop="orderid">
					<el-input v-model="ruleForm.orderid" placeholder="orderid" clearable  :readonly="ro.orderid"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="orderid" prop="orderid">
					<el-input v-model="ruleForm.orderid" placeholder="orderid" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="area" prop="area">
					<el-input v-model="ruleForm.area" placeholder="area" clearable  :readonly="ro.area"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="area" prop="area">
					<el-input v-model="ruleForm.area" placeholder="area" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="price" prop="price">
					<el-input v-model="ruleForm.price" placeholder="price" clearable  :readonly="ro.price"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="price" prop="price">
					<el-input v-model="ruleForm.price" placeholder="price" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="ridetime" prop="ridetime">
					<el-input v-model="ruleForm.ridetime" placeholder="ridetime" clearable  :readonly="ro.ridetime"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="ridetime" prop="ridetime">
					<el-input v-model="ruleForm.ridetime" placeholder="ridetime" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="starttime" prop="starttime">
					<el-input v-model="ruleForm.starttime" placeholder="starttime" clearable  :readonly="ro.starttime"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="starttime" prop="starttime">
					<el-input v-model="ruleForm.starttime" placeholder="starttime" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="week" prop="week">
					<el-input v-model="ruleForm.week" placeholder="week" clearable  :readonly="ro.week"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"49%","float":"left","margin":"0 0 20px 0"}' v-else class="input" label="week" prop="week">
					<el-input v-model="ruleForm.week" placeholder="week" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"clear":"both","width":"100%","padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"1px solid #409eff","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"4px","background":"-webkit-linear-gradient(top,#7dbcfe,#409eff)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"1px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(64, 158, 255, 1)","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"1px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"rgba(64, 158, 255, 1)","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				bid : false,
				account : false,
				pp : false,
				month : false,
				orderid : false,
				area : false,
				price : false,
				ridetime : false,
				starttime : false,
				userid : false,
				week : false,
			},
			
			
			ruleForm: {
				bid: '',
				account: '',
				pp: '',
				month: '',
				orderid: '',
				area: '',
				price: '',
				ridetime: '',
				starttime: '',
				userid: '',
				week: '',
			},
		
			
			rules: {
				bid: [
				],
				account: [
				],
				pp: [
				],
				month: [
				],
				orderid: [
				],
				area: [
				],
				price: [
				],
				ridetime: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				starttime: [
				],
				userid: [
				],
				week: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='bid'){
							this.ruleForm.bid = obj[o];
							this.ro.bid = true;
							continue;
						}
						if(o=='account'){
							this.ruleForm.account = obj[o];
							this.ro.account = true;
							continue;
						}
						if(o=='pp'){
							this.ruleForm.pp = obj[o];
							this.ro.pp = true;
							continue;
						}
						if(o=='month'){
							this.ruleForm.month = obj[o];
							this.ro.month = true;
							continue;
						}
						if(o=='orderid'){
							this.ruleForm.orderid = obj[o];
							this.ro.orderid = true;
							continue;
						}
						if(o=='area'){
							this.ruleForm.area = obj[o];
							this.ro.area = true;
							continue;
						}
						if(o=='price'){
							this.ruleForm.price = obj[o];
							this.ro.price = true;
							continue;
						}
						if(o=='ridetime'){
							this.ruleForm.ridetime = obj[o];
							this.ro.ridetime = true;
							continue;
						}
						if(o=='starttime'){
							this.ruleForm.starttime = obj[o];
							this.ro.starttime = true;
							continue;
						}
						if(o=='userid'){
							this.ruleForm.userid = obj[o];
							this.ro.userid = true;
							continue;
						}
						if(o=='week'){
							this.ruleForm.week = obj[o];
							this.ro.week = true;
							continue;
						}
				}
				











			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `gongxiangdanche/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {























var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "gongxiangdanche/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `gongxiangdanche/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.gongxiangdancheCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `gongxiangdanche/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.gongxiangdancheCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.gongxiangdancheCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 80px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  float: left;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #ccc;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #888;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 36px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #ccc;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #888;
	  	  width: auto;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #ccc;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #888;
	  	  width: auto;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #ccc;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #999;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #ccc;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #999;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #ccc;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #999;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 120px;
	  	  text-align: center;
	  	  height: 120px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #ccc;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #888;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  min-height: 150px;
	  	  height: auto;
	  	}
</style>
