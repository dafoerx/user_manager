<template>
  <div>
    <div :class="index > 0 ? 'info' : ''"
         v-for="(item, index) in userList"
         :key="index">
      <el-descriptions class="margin-top"
                       :title="item.nickname"
                       :column="3"
                       size="medium"
                       border>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            用户名
          </template>
          {{ item.username }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号
          </template>
          {{ item.phone }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-camera"></i>
            性别
          </template>
          {{ item.sex === '0' ? '男' : '女' }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-tickets"></i>
            注册时间
          </template>
          {{ item.createTime }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-edit-outline"></i>
            个人描述
          </template>
          {{ item.describe }}
        </el-descriptions-item>
      </el-descriptions>
    </div>
  </div>

</template>

<script>
import user from '../api/user'

export default {
  data() {
    return {
      userList: [],
    }
  },
  created() {
    user.findUserList(1, 10).then((res) => {
      this.userList = res.data.userList
    })
  },
}
</script>

<style>
.info {
  margin-top: 20px;
}
</style>