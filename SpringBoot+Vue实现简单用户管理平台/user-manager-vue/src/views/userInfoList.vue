<template>
  <div class="app">
    <div :class="index > 0 ? 'info' : ''" v-for="(item, index) in userList" :key="index">
      <el-descriptions class="margin-top"
                       :title="item.nickname"
                       :column="3"
                       size="medium"
                       border>

        <!-- 用户名 -->
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            用户名
          </template>
           {{ item.username }}
        </el-descriptions-item>

        <!-- 手机号码 -->
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
           {{ item.phone }}
        </el-descriptions-item>

        <!-- 性别 -->
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-s-check"></i>
            性别
          </template>
          {{ item.sex === '0' ? '男' : '女' }}
        </el-descriptions-item>

        <!-- 注册时间 -->
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            注册时间
          </template>
          {{ item.createTime }}
        </el-descriptions-item>

        <!-- 个人描述 -->
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-edit-outline"></i>
            个人描述
          </template>
        {{ item.describe }}
        </el-descriptions-item>
      </el-descriptions>
    </div>

    <!-- 分页 -->
    <div class="block"
         style="text-align:center;margin-top:10px;">
      <el-pagination background
                     @current-change="handleCurrentChange"
                     :current-page.sync="pageParam.index"
                     :page-size="pageParam.size"
                     :total="pageParam.total"
                     layout="prev, pager, next, jumper">
      </el-pagination>
    </div>
  </div>
</template>

<script>
// 引入接口
import user from '../api/user'

export default {
  data() {
    return {
      // 用户信息列表
      userList: [],
      // 分页
      pageParam: {
        index: 1,
        size: 4,
        total: 0,
      },
    }
  },
  methods: {
    // 切页
    handleCurrentChange(index) {
      this.pageParam.index = index
      this.getUserList()
    },
    getUserList() {
      // 发送请求，获取用户信息列表
      user.findUserList(this.pageParam.index, this.pageParam.size).then((res) => {
        // 赋值
        this.userList = res.data.userList
        // 总数赋值
        this.pageParam.total = res.data.total
      })
    }
  },
  created() {
    this.getUserList()
  },
}
</script>

<style>
.info {
  margin-top: 20px;
}
</style>