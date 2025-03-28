<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221013/8a26e3be658c402687a7bd422c747cd2.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"width":"100%","padding":"0 0 0 55%","margin":"0","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20221013/dfddd3a63f7f4a32a8303621084ea5f4.png) #fff no-repeat 15% center","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"width":"100%","margin":"20px 0 15px 0px","lineHeight":"40px","fontSize":"24px","color":"#126797","textShadow":"0px 0px 0px #0e64a0"}' class="title">基于Spark的共享单车数据存储系统的设计与实现注册</div>
				<el-form-item :style='{"width":"80%","margin":"0 auto 10px","position":"relative","alignItems":"center","flexWrap":"wrap","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"color":"#333","top":"4px","left":"-120px","textAlign":"right","width":"104px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable">用户账号</div>
					<el-input  v-model="ruleForm.yonghuzhanghao"  autocomplete="off" placeholder="用户账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","margin":"0 auto 10px","position":"relative","alignItems":"center","flexWrap":"wrap","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"color":"#333","top":"4px","left":"-120px","textAlign":"right","width":"104px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable">密码</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","margin":"0 auto 10px","position":"relative","alignItems":"center","flexWrap":"wrap","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"color":"#333","top":"4px","left":"-120px","textAlign":"right","width":"104px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable">确认密码</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","margin":"0 auto 10px","position":"relative","alignItems":"center","flexWrap":"wrap","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"color":"#333","top":"4px","left":"-120px","textAlign":"right","width":"104px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable">用户姓名</div>
					<el-input  v-model="ruleForm.yonghuxingming"  autocomplete="off" placeholder="用户姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","margin":"0 auto 10px","position":"relative","alignItems":"center","flexWrap":"wrap","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"color":"#333","top":"4px","left":"-120px","textAlign":"right","width":"104px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable">性别</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yonghuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","margin":"0 auto 10px","position":"relative","alignItems":"center","flexWrap":"wrap","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"color":"#333","top":"4px","left":"-120px","textAlign":"right","width":"104px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable">用户电话</div>
					<el-input  v-model="ruleForm.yonghudianhua"  autocomplete="off" placeholder="用户电话"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","margin":"0 auto 10px","position":"relative","alignItems":"center","flexWrap":"wrap","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"color":"#333","top":"4px","left":"-120px","textAlign":"right","width":"104px","lineHeight":"40px","fontSize":"16px","position":"absolute"}' class="lable">头像</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yonghutouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<button :style='{"border":"1px solid #cfd019","cursor":"pointer","padding":"0 24px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"0 0 5px 71px","color":"#4f4e34","letterSpacing":"5px","outline":"none","borderRadius":"5px","background":"-webkit-linear-gradient(top,#faf93f,#e3d719)","width":"105px","fontSize":"18px","height":"40px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0 10%","margin":"0 0 20px 0","color":"#ccc","display":"block","lineHeight":"2","fontSize":"14px","textDecoration":"underline"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>

export default {
	data() {
		return {
			ruleForm: {
                xingbie: '',
			},

            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
		};
	},
	mounted(){
        this.pageFlag = this.$storage.get("pageFlag");
		let table = this.$storage.get("loginTable");
		this.tableName = table;
        this.yonghuxingbieOptions = "男,女".split(',')
	},
	created() {
    
	},
	destroyed() {
		  	},
	methods: {
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
						this.$message.error(`用户账号不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.mima) && `yonghu` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
						this.$message.error(`用户姓名不能为空`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`yonghu` == this.tableName && this.ruleForm.yonghudianhua&&(!this.$validate.isMobile(this.ruleForm.yonghudianhua))){
						this.$message.error(`用户电话应输入手机格式`);
						return
					}
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
				
			
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20221013/8a26e3be658c402687a7bd422c747cd2.png);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #c6ccdd;
						border-radius: 4px;
						padding: 0 20px;
						box-shadow: 0 2px 3px #ecedf3;
						outline: none;
						color: #aaa;
						background: #fff;
						width: 280px;
						font-size: 14px;
						height: 36px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #c6ccdd;
						border-radius: 4px;
						padding: 0 20px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #ccc;
						background: #fff;
						width: 280px;
						font-size: 14px;
						height: 36px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #c6ccdd;
						border-radius: 4px;
						padding: 0 20px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #ccc;
						background: #fff;
						width: 280px;
						font-size: 16px;
						line-height: 40px;
						height: 36px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #c6ccdd;
						border-radius: 4px;
						padding: 0 20px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #ccc;
						background: #fff;
						width: 280px;
						font-size: 16px;
						line-height: 40px;
						height: 36px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px dashed #aaaaaa;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #ccc;
		  		  width: 160px;
		  		  font-size: 30px;
		  		  min-height: 100px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: auto;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px dashed #aaaaaa;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #ccc;
		  		  width: 160px;
		  		  font-size: 30px;
		  		  min-height: 100px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: auto;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px dashed #aaaaaa;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #ccc;
		  		  width: 160px;
		  		  font-size: 30px;
		  		  min-height: 100px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: auto;
		  		}
	}
</style>
