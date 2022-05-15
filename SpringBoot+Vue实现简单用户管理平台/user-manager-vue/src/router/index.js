import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '../views/index.vue'

Vue.use(VueRouter)

const routes = [
  {
		path: "/",
		name: "用户管理",
		component: index,
    class: 'el-icon-s-custom',
		children: [
			{
				path: "/",
				name: "数据列表",
				component: () => import("../views/userList.vue")
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
				component: () => import("../views/userInfoList.vue")
			}
		],
	},
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
