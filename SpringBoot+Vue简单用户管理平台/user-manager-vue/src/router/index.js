import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
		path: "/",
		name: "用户管理",
		component: Home,
    class: 'el-icon-s-custom',
		children: [
			{
				path: "/",
				name: "数据列表",
				component: () => import("../views/UserInfoList.vue")
			},
      {
				path: "/addUser",
				name: "添加用户",
				component: () => import("../views/addUser.vue")
			},
      {
				path: "/editUser/:id",
				name: "编辑用户",
				component: () => import("../views/addUser.vue"),
        hidden: true //隐式路由
			},
			{
				path: "/userInfo",
				name: "用户信息",
				component: () => import("../views/UserInfo.vue")
			}
		],
	},
]

const router = new VueRouter({
  base: process.env.BASE_URL,
  routes
})

export default router
