const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot71220/",
            name: "springboot71220",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "基于Spark的共享单车数据存储系统的设计与实现"
        } 
    }
}
export default base
