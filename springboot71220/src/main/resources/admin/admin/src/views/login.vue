<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221013/8a26e3be658c402687a7bd422c747cd2.png)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>

      <el-form :style='{"width":"100%","padding":"0 0 0 55%","margin":"0","borderRadius":"0","background":"url(http://codegen.caihongy.cn/20221013/dfddd3a63f7f4a32a8303621084ea5f4.png) #fff no-repeat 15% center","height":"auto"}'>
        <div v-if="true" :style='{"width":"100%","margin":"40px 0 0px 30px","lineHeight":"40px","fontSize":"24px","color":"#126797","textShadow":"0px 0px 0px #0e64a0"}' class="title-container">基于Spark的共享单车数据存储系统的设计与实现登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 auto 10px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#333","top":"15px","left":"-150px","textAlign":"right","width":"150px","lineHeight":"40px","fontSize":"16px","position":"absolute"}'>用户名：</div>
          <input :style='{"border":"1px solid #c6ccdd","padding":"0 25px","boxShadow":"0 2px 3px #ecedf3","outline":"0px solid #efefef","margin":"15px 0px 0px","color":"#aaa","outlineOffset":"0px","borderRadius":"4px","background":"#fff","width":"280px","fontSize":"14px","height":"40px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 auto 10px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"#333","top":"15px","left":"-150px","textAlign":"right","width":"150px","lineHeight":"40px","fontSize":"16px","position":"absolute"}'>密码：</div>
          <input :style='{"border":"1px solid #c6ccdd","padding":"0 25px","boxShadow":"0 2px 3px #ecedf3","outline":"0px solid #efefef","margin":"15px 0px 0px","color":"#aaa","outlineOffset":"0px","borderRadius":"4px","background":"#fff","width":"280px","fontSize":"14px","height":"40px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>
        <div :style='{"color":"#ffffff","width":"80%","margin":"20px auto"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>
        <div :style='{"width":"375px","margin":"0 0 60px 65px","alignItems":"left","justifyContent":"left","display":"flex"}'>
          <el-button v-if="loginType==1" :style='{"border":"1px solid #cfd019","cursor":"pointer","padding":"0 20px","margin":"0 10px 0 20px","outline":"none","color":"#4f4e34","borderRadius":"5px","background":"-webkit-linear-gradient(top,#faf93f,#e3d719)","width":"auto","letterSpacing":"5px","fontSize":"16px","height":"40px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
          <el-button :style='{"border":"1px solid #999","cursor":"pointer","padding":"0 20px","margin":"0 5px","outline":"none","color":"#fff","borderRadius":"5px","textAlign":"center","background":"-webkit-linear-gradient(top,#c9c9c9,#999)","width":"auto","fontSize":"16px","height":"40px"}' type="primary" @click="register('yonghu')" class="register">注册用户</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>

import menu from "@/utils/menu";
export default {
  data() {
    return {
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
        code: '',
      },
      menus: [],
      roles: [],
      tableName: "",
      codes: [{
        num: 1,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 2,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 3,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 4,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }],
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {
    this.getRandCode()
  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
        this.$storage.set("pageFlag", "register");
		this.$router.push({path:'/register'})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}

		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/index/" });
			} else {
				this.$message.error(data.msg);
			}
		});
    },
    getRandCode(len = 4){
		this.randomString(len)
    },
    randomString(len = 4) {
      let chars = [
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
          "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
          "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
          "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
          "3", "4", "5", "6", "7", "8", "9"
      ]
      let colors = ["0", "1", "2","3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
      let sizes = ['14', '15', '16', '17', '18']

      let output = [];
      for (let i = 0; i < len; i++) {
        // 随机验证码
        let key = Math.floor(Math.random()*chars.length)
        this.codes[i].num = chars[key]
        // 随机验证码颜色
        let code = '#'
        for (let j = 0; j < 6; j++) {
          let key = Math.floor(Math.random()*colors.length)
          code += colors[key]
        }
        this.codes[i].color = code
        // 随机验证码方向
        let rotate = Math.floor(Math.random()*60)
        let plus = Math.floor(Math.random()*2)
        if(plus == 1) rotate = '-'+rotate
        this.codes[i].rotate = 'rotate('+rotate+'deg)'
        // 随机验证码字体大小
        let size = Math.floor(Math.random()*sizes.length)
        this.codes[i].size = sizes[size]+'px'
      }
    },
  }
};
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20221013/8a26e3be658c402687a7bd422c747cd2.png);
        
  .list-item /deep/ .el-input .el-input__inner {
		border: 1px solid #c6ccdd;
		border-radius: 4px;
		padding: 0 25px;
		box-shadow: 0 2px 3px #ecedf3;
		outline: 0px solid #efefef;
		margin: 15px 0px 0px;
		color: #aaa;
		background: #fff;
		width: 280px;
		font-size: 14px;
		outline-offset: 0px;
		height: 40px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border: 1px solid #c6ccdd;
  	  	border-radius: 4px;
  	  	padding: 0 25px;
  	  	outline: none;
  	  	margin: 0px 20px 0px 0px;
  	  	color: #ccc;
  	  	background: #fff;
  	  	width: 280px;
  	  	font-size: 14px;
  	  	height: 40px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		border: 1px solid #ccc;
		background: #f3f3f3;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        border: 1px solid #5fb1ea;
        background: #409dde;
        border-color: #2a8ed4;
      }
  .list-type /deep/ .el-radio__label {
		color: #333;
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: rgba(64, 158, 255, 1);
        font-size: 14px;
      }
}
</style>
