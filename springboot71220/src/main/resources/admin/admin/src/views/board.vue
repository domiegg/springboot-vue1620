<template>
<div class="content box5" :style='{"alignContent":"flex-start","minHeight":"100vh","flexWrap":"wrap","background":"#021132","display":"flex","width":"100%","position":"relative","height":"auto"}'>
	<!-- 标题 -->
	<div :style='{"margin":"0 0 40px 0","color":"#fff","textAlign":"center","background":"url(http://codegen.caihongy.cn/20230302/fafcfb34c12947e3b16c93023c4a89ce.gif) no-repeat center top,url(http://codegen.caihongy.cn/20230302/13adc86938e9432f8df0abed38487901.png) no-repeat center top","width":"100%","lineHeight":"130px","fontSize":"22px","height":"111px","order":"-999"}'>欢迎使用 {{this.$project.projectName}}</div>
	<!-- 时间 -->
	<div :style='{"top":"0px","color":"#fff","left":"60px","display":"inline-block","lineHeight":"58px","fontSize":"16px","position":"absolute","height":"64px"}' class="times">{{ dates }}</div>
	<!-- 系统简介 -->
	<div v-if="systemIntroductionDetail" :style='{"padding":"20px","margin":"0 1% 40px 3%","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230302/0a83a226537147a5b31531226c6b039b.gif) no-repeat left top / 100% 100%","display":"block","width":"26%","height":"500px","order":"-9"}'>
		<el-carousel :style='{"width":"100%","margin":"0 auto","height":"240px"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="240px" :autoplay="true" :interval="3000" :loop="true">
			<el-carousel-item :style='{"borderRadius":"10px","width":"100%","height":"100%"}' v-if="systemIntroductionDetail.picture1">
				<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="$base.url+ systemIntroductionDetail.picture1" fit="cover"></el-image>
			</el-carousel-item>
			<el-carousel-item :style='{"borderRadius":"10px","width":"100%","height":"100%"}' v-if="systemIntroductionDetail.picture2">
				<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="$base.url+ systemIntroductionDetail.picture2" fit="cover"></el-image>
			</el-carousel-item>
			<el-carousel-item :style='{"borderRadius":"10px","width":"100%","height":"100%"}' v-if="systemIntroductionDetail.picture3">
				<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="$base.url+ systemIntroductionDetail.picture3" fit="cover"></el-image>
			</el-carousel-item>
		</el-carousel>
		<div :style='{"margin":"20px 0 0 0px","overflow":"hidden","color":"#fff","background":"none","lineHeight":"24px","fontSize":"14px","textIndent":"2em","height":"168px"}' v-html="systemIntroductionDetail.content"></div>
	</div>
	<!-- 统计 -->
	<div :style='{"alignContent":"flex-start","padding":"20px","margin":"0 1% 40px 1%","flexWrap":"wrap","background":"url(http://codegen.caihongy.cn/20230302/b1ee8936f19a48798fe5eda49f1686b0.gif) no-repeat right bottom,url(http://codegen.caihongy.cn/20230302/b1ee8936f19a48798fe5eda49f1686b0.gif) no-repeat left top,url(http://codegen.caihongy.cn/20230301/eebc93a9958a499499d062be5af8ea63.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20230301/082aaea4f77e41b78bd052b894925ae7.png) no-repeat left bottom / 100% auto,url(http://codegen.caihongy.cn/20230301/dfd8db23440b4579893f9100b1aa935f.png) repeat-y center center / 100% auto","display":"flex","width":"28%","height":"500px","order":"-8"}'>
<!-- 1 -->

		<div :style='{"width":"100%","margin":"0 0 20px","alignItems":"center","background":"rgba(255,255,255,.1)","justifyContent":"center","display":"flex"}'>
			<div :style='{"width":"32px","background":"#2e9ae6","height":"32px"}'></div>
			<div :style='{"padding":"0 20px","alignItems":"center","flex":"1","justifyContent":"space-between","display":"flex"}'>
				<div :style='{"lineHeight":"32px","fontSize":"16px","color":"#fff","height":"32px"}'>共享单车总数</div>
				<div :style='{"lineHeight":"32px","fontSize":"20px","color":"#fff","fontWeight":"bold","height":"32px"}'>{{gongxiangdancheCount}}</div>
			</div>
		</div>

	</div>

	<div class="tables">
		<div :style='{"margin":"0 0 20px 0","color":"#fff","textAlign":"center","background":"rgba(255,255,255,.1)","width":"100%","lineHeight":"64px","fontSize":"28px","height":"64px"}'>共享单车</div>
        <el-table :data="boardDataList" border :stripe="false" :style='{"width":"100%","padding":"0","borderColor":"#333","borderStyle":"solid","borderWidth":"1px 0 0 1px","background":"none"}'>
          <el-table-column :resizable="true" :sortable="false" prop="bid" label="bid"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="account" label="account"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="pp" label="pp"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="month" label="month"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="orderid" label="orderid"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="area" label="area"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="price" label="price"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="ridetime" label="ridetime"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="starttime" label="starttime"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="userid" label="userid"/>
          </el-table-column>
          <el-table-column :resizable="true" :sortable="false" prop="week" label="week"/>
          </el-table-column>
        </el-table>
	</div>
	
	<div class="echarts1">
		<div id="gongxiangdancheChart1" style="width:100%;height:100%;"></div>
	</div>
	<div class="echarts2">
		<div id="gongxiangdancheChart2" style="width:100%;height:100%;"></div>
	</div>
	<div class="echarts3">
		<div id="gongxiangdancheChart3" style="width:100%;height:100%;"></div>
	</div>
	<div class="echarts4">
		<div id="gongxiangdancheChart4" style="width:100%;height:100%;"></div>
	</div>
	<div class="echarts5">
		<div id="gongxiangdancheChart5" style="width:100%;height:100%;"></div>
	</div>

</div>


</template>
<script>
import * as echarts from 'echarts'
//1
//5
import router from '@/router/router-static'
export default {
	data() {
		return {
			line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#ccc","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(250,250,250,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(255,255,255,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"rgb(255,255,255)","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"symbol":"emptyCircle","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"showSymbol":true,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"","shadowBlur":0,"width":2,"type":"solid","opacity":1,"shadowColor":"#000"},"symbolSize":4},"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"}},
			bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#ccc","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(250,250,250,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(255,255,255,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00ff00","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"rgb(255,255,255)","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"barWidth":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"colorBy":"data","barCategoryGap":"20%"},"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"base":{"animate":true,"interval":3000}},
			pie: {"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"#fff","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false},"top":40}},
			myChart0: null,
			boardDataList: [],
            systemIntroductionDetail: null,
			dates: '',
            gongxiangdancheCount: 0,
		};
	},
  mounted(){
    this.init();
    this.getDataList();
    this.getgongxiangdancheCount();
    this.gongxiangdancheChat1();
    this.gongxiangdancheChat2();
    this.gongxiangdancheChat3();
    this.gongxiangdancheChat4();
    this.gongxiangdancheChat5();
  },
  created() {
    this.$nextTick(()=>{
		this.times()
	})
  },
  methods:{
	myChartInterval(type, xAxisData, seriesData, myChart) {
	  this.$nextTick(() => {
	    setInterval(() => {
	      let xAxis = xAxisData.shift()
	      xAxisData.push(xAxis)
	      let series = seriesData.shift()
	      seriesData.push(series)
			
			if (type == 1) {
				myChart.setOption({
				  xAxis: [{
				    data: xAxisData
				  }],
				  series: [{
				    data: seriesData
				  }]
				});
			}
			if (type == 2) {
				myChart.setOption({
				  yAxis: [{
				    data: xAxisData
				  }],
				  series: [{
				    data: seriesData
				  }]
				});
			}
	    }, 3000);
	  })
	},
    getDataList() {
      let params = {
        page: 1,
        limit: 10,
      }
      this.$http({
        url: "gongxiangdanche/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.boardDataList = data.data.list;
        }
      });
    },
	wordclouds(wordcloudData,echartsId) {
		let wordcloud = {"maskImage":"data:image/png;base64,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","option":{"tooltip":{"show":false},"backgroundColor":"transparent","series":[{"sizeRange":[9,32],"layoutAnimation":true,"shape":"circle","data":[{"name":"花鸟市场","value":1446},{"name":"汽车","value":928},{"name":"视频","value":906},{"name":"电视","value":825},{"name":"Lover Boy 88","value":514},{"name":"动漫","value":486},{"name":"音乐","value":53},{"name":"直播","value":163},{"name":"广播电台","value":86},{"name":"戏曲曲艺","value":17},{"name":"演出票务","value":6},{"name":"给陌生的你听","value":1},{"name":"资讯","value":1437},{"name":"商业财经","value":422},{"name":"娱乐八卦","value":353},{"name":"军事","value":331},{"name":"科技资讯","value":313},{"name":"社会时政","value":307},{"name":"时尚","value":43},{"name":"网络奇闻","value":15},{"name":"旅游出行","value":438},{"name":"景点类型","value":957},{"name":"国内游","value":927},{"name":"远途出行方式","value":908},{"name":"酒店","value":693},{"name":"关注景点","value":611},{"name":"旅游网站偏好","value":512},{"name":"出国游","value":382},{"name":"交通票务","value":312},{"name":"旅游方式","value":187},{"name":"旅游主题","value":163},{"name":"港澳台","value":104},{"name":"本地周边游","value":3},{"name":"小卖家","value":1331},{"name":"全日制学校","value":941},{"name":"基础教育科目","value":585},{"name":"考试培训","value":473},{"name":"语言学习","value":358},{"name":"留学","value":246},{"name":"K12课程培训","value":207},{"name":"艺术培训","value":194},{"name":"技能培训","value":104},{"name":"IT培训","value":87},{"name":"高等教育专业","value":63},{"name":"家教","value":48},{"name":"体育培训","value":23},{"name":"职场培训","value":5},{"name":"金融财经","value":1328},{"name":"银行","value":765},{"name":"股票","value":452},{"name":"保险","value":415},{"name":"贷款","value":253},{"name":"基金","value":211},{"name":"信用卡","value":180},{"name":"外汇","value":138},{"name":"P2P","value":116},{"name":"贵金属","value":98},{"name":"债券","value":93},{"name":"网络理财","value":92},{"name":"信托","value":90},{"name":"征信","value":76},{"name":"期货","value":76},{"name":"公积金","value":40},{"name":"银行理财","value":36},{"name":"银行业务","value":30},{"name":"典当","value":7},{"name":"海外置业","value":1},{"name":"汽车","value":1309},{"name":"汽车档次","value":965},{"name":"汽车品牌","value":900},{"name":"汽车车型","value":727},{"name":"购车阶段","value":461},{"name":"二手车","value":309},{"name":"汽车美容","value":260},{"name":"新能源汽车","value":173},{"name":"汽车维修","value":155},{"name":"租车服务","value":136},{"name":"车展","value":121},{"name":"违章查询","value":76},{"name":"汽车改装","value":62},{"name":"汽车用品","value":37},{"name":"路况查询","value":32},{"name":"汽车保险","value":28},{"name":"陪驾代驾","value":4},{"name":"网络购物","value":1275},{"name":"做我的猫","value":1088},{"name":"只想要你知道","value":907},{"name":"团购","value":837},{"name":"比价","value":201},{"name":"海淘","value":195},{"name":"移动APP购物","value":179},{"name":"支付方式","value":119},{"name":"代购","value":43},{"name":"体育健身","value":1234},{"name":"体育赛事项目","value":802},{"name":"运动项目","value":405},{"name":"体育类赛事","value":337},{"name":"健身项目","value":199},{"name":"健身房健身","value":78},{"name":"运动健身","value":77},{"name":"家庭健身","value":36},{"name":"健身器械","value":29},{"name":"办公室健身","value":3},{"name":"商务服务","value":1201},{"name":"法律咨询","value":508},{"name":"化工材料","value":147},{"name":"广告服务","value":125},{"name":"会计审计","value":115},{"name":"人员招聘","value":101},{"name":"印刷打印","value":66},{"name":"知识产权","value":32},{"name":"翻译","value":22},{"name":"安全安保","value":9},{"name":"公关服务","value":8},{"name":"商旅服务","value":2},{"name":"展会服务","value":2},{"name":"特许经营","value":1},{"name":"休闲爱好","value":1169},{"name":"收藏","value":412},{"name":"摄影","value":393},{"name":"温泉","value":230},{"name":"博彩彩票","value":211},{"name":"美术","value":207},{"name":"书法","value":139},{"name":"DIY手工","value":75},{"name":"舞蹈","value":23},{"name":"钓鱼","value":21},{"name":"棋牌桌游","value":17},{"name":"KTV","value":6},{"name":"密室","value":5},{"name":"采摘","value":4},{"name":"电玩","value":1},{"name":"真人CS","value":1},{"name":"轰趴","value":1},{"name":"家电数码","value":1111},{"name":"手机","value":885},{"name":"电脑","value":543},{"name":"大家电","value":321},{"name":"家电关注品牌","value":253},{"name":"网络设备","value":162},{"name":"摄影器材","value":149},{"name":"影音设备","value":133},{"name":"办公数码设备","value":113},{"name":"生活电器","value":67},{"name":"厨房电器","value":54},{"name":"智能设备","value":45},{"name":"个人护理电器","value":22},{"name":"服饰鞋包","value":1047},{"name":"服装","value":566},{"name":"饰品","value":289},{"name":"鞋","value":184},{"name":"箱包","value":168},{"name":"奢侈品","value":137},{"name":"母婴亲子","value":1041},{"name":"孕婴保健","value":505},{"name":"母婴社区","value":299},{"name":"早教","value":103},{"name":"奶粉辅食","value":66},{"name":"童车童床","value":41},{"name":"关注品牌","value":271},{"name":"宝宝玩乐","value":30},{"name":"母婴护理服务","value":25},{"name":"纸尿裤湿巾","value":16},{"name":"妈妈用品","value":15},{"name":"宝宝起名","value":12},{"name":"童装童鞋","value":9},{"name":"胎教","value":8},{"name":"宝宝安全","value":1},{"name":"宝宝洗护用品","value":1},{"name":"软件应用","value":1018},{"name":"系统工具","value":896},{"name":"理财购物","value":440},{"name":"生活实用","value":365},{"name":"影音图像","value":256},{"name":"社交通讯","value":214},{"name":"手机美化","value":39},{"name":"办公学习","value":28},{"name":"应用市场","value":23},{"name":"母婴育儿","value":14},{"name":"游戏","value":946},{"name":"手机游戏","value":565},{"name":"PC游戏","value":353},{"name":"网页游戏","value":254},{"name":"游戏机","value":188},{"name":"模拟辅助","value":166},{"name":"个护美容","value":942},{"name":"护肤品","value":177},{"name":"彩妆","value":133},{"name":"美发","value":80},{"name":"香水","value":50},{"name":"个人护理","value":46},{"name":"美甲","value":26},{"name":"SPA美体","value":21},{"name":"花鸟萌宠","value":914},{"name":"绿植花卉","value":311},{"name":"狗","value":257},{"name":"其他宠物","value":131},{"name":"水族","value":125},{"name":"猫","value":122},{"name":"动物","value":81},{"name":"鸟","value":67},{"name":"宠物用品","value":41},{"name":"宠物服务","value":26},{"name":"书籍阅读","value":913},{"name":"网络小说","value":483},{"name":"关注书籍","value":128},{"name":"文学","value":105},{"name":"报刊杂志","value":77},{"name":"人文社科","value":22},{"name":"建材家居","value":907},{"name":"装修建材","value":644},{"name":"家具","value":273},{"name":"家居风格","value":187},{"name":"家居家装关注品牌","value":140},{"name":"家纺","value":107},{"name":"厨具","value":47},{"name":"灯具","value":43},{"name":"家居饰品","value":29},{"name":"家居日常用品","value":10},{"name":"生活服务","value":883},{"name":"物流配送","value":536},{"name":"家政服务","value":108},{"name":"摄影服务","value":49},{"name":"搬家服务","value":38},{"name":"物业维修","value":37},{"name":"婚庆服务","value":24},{"name":"二手回收","value":24},{"name":"鲜花配送","value":3},{"name":"维修服务","value":3},{"name":"殡葬服务","value":1},{"name":"求职创业","value":874},{"name":"创业","value":363},{"name":"目标职位","value":162},{"name":"目标行业","value":50},{"name":"兼职","value":21},{"name":"期望年薪","value":20},{"name":"实习","value":16},{"name":"雇主类型","value":10},{"name":"星座运势","value":789},{"name":"星座","value":316},{"name":"算命","value":303},{"name":"解梦","value":196},{"name":"风水","value":93},{"name":"面相分析","value":47},{"name":"手相","value":32},{"name":"公益","value":90}],"keepAspect":false,"type":"wordCloud","rotationRange":[-90,90],"gridSize":8,"shrinkToFit":false,"top":"center","left":"center","width":"80%","emphasis":{"focus":"self","textStyle":{"textShadowColor":"#333","textShadowBlur":4}},"drawOutOfBound":false,"rotationStep":45,"textStyle":{"color":"function(){return\"rgb(\"+[Math.round(160*Math.random()),Math.round(160*Math.random()),Math.round(160*Math.random())].join(\",\")+\")\"}","fontWeight":500,"fontFamily":"sans-serif"},"height":"80%","maskImage":{}}]}}
		wordcloud = JSON.parse(JSON.stringify(wordcloud), (k, v) => {
		  if(typeof v == 'string' && v.indexOf('function') > -1){
		    return eval("(function(){return "+v+" })()")
		  }
		  return v;
		})
		wordcloud.option.series[0].data=wordcloudData;
		
		this.myChart0 = echarts.init(document.getElementById(echartsId));
		let myChart = this.myChart0
		let img = wordcloud.maskImage
	
		if (img) {
			var maskImage = new Image();
			maskImage.src = img
			maskImage.onload = function() {
				wordcloud.option.series[0].maskImage = maskImage
				myChart.clear()
				myChart.setOption(wordcloud.option)
			}
		} else {
			delete wordcloud.option.series[0].maskImage
			myChart.clear()
			myChart.setOption(wordcloud.option)
		}
	},
    getTimeStrToDay(game_over_timestamp) {
        if (game_over_timestamp == 0)
            return "";
        var date = new Date(parseInt(game_over_timestamp));
        var now = new Date();
        var hours = date.getHours() >= 10 ? date.getHours().toString() : "0" + date.getHours();
        var minutes = date.getMinutes() >= 10 ? date.getMinutes().toString() : "0" + date.getMinutes();
        var seconds = date.getSeconds() >= 10 ? date.getSeconds().toString() : "0" + date.getSeconds();
        let arr = ["日", "一", "二", "三", "四", "五", "六"];
        let d = arr[date.getDay()]
        return date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + '日' + ' ' + ' ' + '星期' + d  + ' ' + "  " + hours + ":" + minutes + ":" + seconds
    },
	times() {
		setInterval(()=>{
            let date = new Date().getTime()
            this.dates = this.getTimeStrToDay(date)
		}, 1000)
	},
	filterTime(time) {
	  const date = new Date(time)
	  const Y = date.getFullYear()
	  const M = date.getMonth() + 1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1 
	  const D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
	  
	  const H = date.getHours() < 10 ? '0' + date.getHours() : date.getHours() // 小时
	  const I = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes() // 分钟
	  const S = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds() // 秒
	  
	  return `${Y}-${M}-${D} ${H}:${I}:${S}`
	},
    getSystemIntroduction() {
        this.$http({
            url: `systemintro/detail/1`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.systemIntroductionDetail = data.data
            }
        })
    },
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
        this.getSystemIntroduction();
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

//统计接口1
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
				let titleObj = this.line.title
				titleObj.text = 'pp统计'
				
				const legendObj = this.line.legend
				
				let xAxisObj = this.line.xAxis
				xAxisObj.type = 'category'
				xAxisObj.boundaryGap = false
				xAxisObj.data = xAxis
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.line.yAxis
				yAxisObj.type = 'value'
				
				let seriesObj = {
					data: yAxis,
					type: 'line',
					areaStyle: {},
					smooth: true
				}
				seriesObj = Object.assign(seriesObj , this.line.series)
				
                option = {
					backgroundColor: this.line.backgroundColor,
					color: this.line.color,
                    title: titleObj,
					legend: legendObj,
                    tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
                    },
                    xAxis: xAxisObj,
                    yAxis: yAxisObj,
                    series: [seriesObj]
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

//统计接口2
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
                let titleObj = this.pie.title
				titleObj.text = 'pp占比'
				
				const legendObj = this.pie.legend
				
				let seriesObj = {
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
				seriesObj = Object.assign(seriesObj , this.pie.series)
				
				option = {
					backgroundColor: this.pie.backgroundColor,
					color: this.pie.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c} ({d}%)'
					},
					series: [seriesObj]
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

//统计接口3
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
				let titleObj = this.bar.title
				titleObj.text = 'month统计'
				
				const legendObj = this.bar.legend
				
				let xAxisObj = this.bar.xAxis
				xAxisObj.type = 'category'
				xAxisObj.data = xAxis
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.bar.yAxis
				yAxisObj.type = 'value'
				
				let seriesObj = {
						data: yAxis,
						type: 'bar'
					}
				seriesObj = Object.assign(seriesObj , this.bar.series)

				option = {
					backgroundColor: this.bar.backgroundColor,
					color: this.bar.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
					},
					xAxis: xAxisObj,
					yAxis: yAxisObj,
					series: [seriesObj]
				};
                // 使用刚指定的配置项和数据显示图表。
                gongxiangdancheChart3.setOption(option);
				
				this.myChartInterval(1, option.xAxis.data, option.series[0].data, gongxiangdancheChart3)

                  //根据窗口的大小变动图表
                window.onresize = function() {
                    gongxiangdancheChart3.resize();
                };
            }
        });
      })
    },

//统计接口4
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
                let titleObj = this.pie.title
				titleObj.text = 'area占比'
				
				const legendObj = this.pie.legend
				
				let seriesObj = {
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
				seriesObj = Object.assign(seriesObj , this.pie.series)
				
				option = {
					backgroundColor: this.pie.backgroundColor,
					color: this.pie.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c} ({d}%)'
					},
					series: [seriesObj]
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

//统计接口5
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
				let titleObj = this.bar.title
				titleObj.text = 'week统计'
				
				const legendObj = this.bar.legend
				
				let xAxisObj = this.bar.xAxis
				xAxisObj.type = 'value'
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.bar.yAxis
				yAxisObj.type = 'category'
				yAxisObj.data = xAxis
				
				let seriesObj = {
						data: yAxis,
						type: 'bar'
					}
				seriesObj = Object.assign(seriesObj , this.bar.series)

				option = {
					backgroundColor: this.bar.backgroundColor,
					color: this.bar.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
					},
					xAxis: xAxisObj,
					yAxis: yAxisObj,
					series: [seriesObj]
				};
                // 使用刚指定的配置项和数据显示图表。
                gongxiangdancheChart5.setOption(option);

				this.myChartInterval(2, option.yAxis.data, option.series[0].data, gongxiangdancheChart5)

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
	
	.box5 .wordcloud {
				padding: 20px;
				margin: 0 1% 20px 3%;
				background: rgba(255,255,255,.1);
				width: 46%;
				transition: 0.3s;
				height: 560px;
			}
	.box5 .tables {
				padding: 20px;
				margin: 0 3% 50px 3%;
				background: url(http://codegen.caihongy.cn/20230302/0a83a226537147a5b31531226c6b039b.gif) no-repeat left top / 100% 100%;
				width: 94%;
				transition: 0.3s;
				height: auto;
				order: 30;
			}
	.box5 .echarts1 {
				padding: 10px;
				margin: 0 3% 40px 1%;
				background: url(http://codegen.caihongy.cn/20230302/4764089121dc42d89b875c7eb2be3cd4.gif) no-repeat right bottom,url(http://codegen.caihongy.cn/20230302/4764089121dc42d89b875c7eb2be3cd4.gif) no-repeat left top,url(http://codegen.caihongy.cn/20230301/eebc93a9958a499499d062be5af8ea63.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20230301/eebc93a9958a499499d062be5af8ea63.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20230301/082aaea4f77e41b78bd052b894925ae7.png) no-repeat left bottom / 100% auto,url(http://codegen.caihongy.cn/20230301/dfd8db23440b4579893f9100b1aa935f.png) repeat-y center center / 100% auto;
				width: 36%;
				transition: 0.3s;
				height: 500px;
				order: -1;
			}
	.box5 .echarts2 {
				padding: 10px;
				margin: 0 1% 40px 3%;
				background: url(http://codegen.caihongy.cn/20230302/0a83a226537147a5b31531226c6b039b.gif) no-repeat left top / 100% 100%;
				width: 46%;
				transition: 0.3s;
				height: 360px;
			}
	.box5 .echarts3 {
				padding: 10px;
				margin: 0 3% 40px 1%;
				background: url(http://codegen.caihongy.cn/20230302/0a83a226537147a5b31531226c6b039b.gif) no-repeat left top / 100% 100%;
				width: 46%;
				transition: 0.3s;
				height: 360px;
			}
	.box5 .echarts4 {
				padding: 10px;
				margin: 0 3% 40px 1%;
				background: url(http://codegen.caihongy.cn/20230302/0a83a226537147a5b31531226c6b039b.gif) no-repeat left top / 100% 100%;
				width: 46%;
				transition: 0.3s;
				height: 360px;
				order: 2;
			}
	.box5 .echarts5 {
				padding: 10px;
				margin: 0 1% 40px 3%;
				background: url(http://codegen.caihongy.cn/20230302/4764089121dc42d89b875c7eb2be3cd4.gif) no-repeat right bottom,url(http://codegen.caihongy.cn/20230302/4764089121dc42d89b875c7eb2be3cd4.gif) no-repeat left top,url(http://codegen.caihongy.cn/20230301/eebc93a9958a499499d062be5af8ea63.png) no-repeat left top / 100% auto,url(http://codegen.caihongy.cn/20230301/082aaea4f77e41b78bd052b894925ae7.png) no-repeat left bottom / 100% auto,url(http://codegen.caihongy.cn/20230301/dfd8db23440b4579893f9100b1aa935f.png) repeat-y center center / 100% auto;
				width: 46%;
				transition: 0.3s;
				height: 360px;
			}
	
	.box5 .wordcloud:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				margin: 0 1% 20px 3%;
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
				width: 46%;
				position: relative;
				height: 560px;
			}
	.box5 .tables:hover {
			}
	.box5 .echarts1:hover {
			}
	.box5 .echarts2:hover {
			}
	.box5 .echarts3:hover {
			}
	.box5 .echarts4:hover {
			}
	.box5 .echarts5:hover {
			}
	
	// table
	.box5 .el-table /deep/ .el-table__header-wrapper thead {
				width: 100%;
			}
	
	.box5 .el-table /deep/ .el-table__header-wrapper thead tr {
				background: none;
			}
	
	.box5 .el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				color: #eee;
				background: none;
				border-color: #333;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.box5 .el-table /deep/ .el-table__header-wrapper thead tr th .cell {
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
	
	.box5 .el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}
	
	.box5 .el-table /deep/ .el-table__body-wrapper tbody tr {
				background: none;
			}
	
	.box5 .el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 6px 0;
				color: #eee;
				background: none;
				border-color: #333;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
		
	.box5 .el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 6px 0;
				color: #eee;
				background: none;
				border-color: #333;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.box5 .el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 6px 0;
				color: #eee;
				background: none;
				border-color: #333;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.box5 .el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}





</style>
