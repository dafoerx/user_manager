<template>
  <div class="app">
    <!-- 查询条件 -->
    <div>
     <el-form :inline="true" :model="queryParam" class="demo-form-inline" ref="queryParam">

        <el-form-item label="用户名" prop="username">
          <el-input v-model="queryParam.username" placeholder="输入用户名"></el-input>
        </el-form-item>

        <el-form-item label="昵称" prop="nickname">
          <el-input v-model="queryParam.nickname" placeholder="请输入昵称"></el-input>
        </el-form-item>

        <el-form-item label="手机号码" prop="phone">
          <el-input v-model="queryParam.phone" placeholder="请输入手机号码"></el-input>
        </el-form-item>

        <el-form-item label="性别" prop="sex">
          <el-select v-model="queryParam.sex" placeholder="选择性别">
            <el-option label="男" value="0"></el-option>
            <el-option label="女" value="1"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="注册时间" prop="time">
          <el-date-picker v-model="queryParam.time"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择注册时间">
          </el-date-picker>
        </el-form-item>

        <el-form-item>
          <el-button type="primary"
                     icon="el-icon-search"
                     @click="submitSearch()">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button icon="el-icon-refresh"
                     @click="clearForm('queryParam')">重置</el-button>
        </el-form-item>
        <el-button v-if="more"
                   type="danger"
                   icon="el-icon-delete"
                   @click="deleteMore()">一键删除</el-button>
      </el-form>
    </div>

    <!-- 用户信息列表 -->
    <el-table ref="multipleTable"
              :data="userList"
              border
              @selection-change="handleSelectionChange"
              style="width: 100%">

      <el-table-column type="selection"
                       width="55">
      </el-table-column>

      <!-- 编号 -->
      <el-table-column label="编号"
                       width="50">
        <template slot-scope="scope">
          <span>{{ scope.row.id }}</span>
        </template>
      </el-table-column>

      <!-- 用户名 -->
      <el-table-column label="用户名"
                       width="150">
        <template slot-scope="scope">
          <span>{{ scope.row.username }}</span>
        </template>
      </el-table-column>

      <!-- 昵称 -->
      <el-table-column label="昵称"
                       width="150">
        <template slot-scope="scope">
          <span>{{ scope.row.nickname }}</span>
        </template>
      </el-table-column>

      <!-- 密码 -->
      <el-table-column label="性别"
                       width="60">
        <template slot-scope="scope">
          <span>{{ scope.row.sex ===  '0' ? '男' : '女' }}</span>
        </template>
      </el-table-column>

      <!-- 手机号码 -->
      <el-table-column label="手机号码"
                       width="150">
        <template slot-scope="scope">
          <span>{{ scope.row.phone }}</span>
        </template>
      </el-table-column>

      <!-- 密码 -->
      <el-table-column label="密码"
                       width="80">
        <template slot-scope="scope">
          <span>{{ scope.row.password }}</span>
        </template>
      </el-table-column>

      <!-- 注册时间 -->
      <el-table-column label="注册时间"
                       width="100">
        <template slot-scope="scope">
          <span>{{ scope.row.gmtCreate }}</span>
        </template>
      </el-table-column>

      <!-- 提议 -->
      <el-table-column label="描述"
                       width="auto">
        <template slot-scope="scope">
          <span>{{ scope.row.describe }}</span>
        </template>
      </el-table-column>

      <el-table-column align="center"
                       label="操作"
                       width="150">
        <template slot-scope="scope">
          <!-- 编辑按钮 -->
          <router-link :to="'/editUser/' + scope.row.id">
            <el-button size="mini"
                       type="warning"
                       icon="el-icon-edit"></el-button>
          </router-link>
          <!-- 删除按钮 -->
          <el-button style="margin-left: 10px;"
                     size="mini"
                     type="danger"
                     icon="el-icon-delete"
                     @click="deleteUser(scope.row.id)"></el-button>
        </template>
      </el-table-column>
    </el-table>

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
import user from '../api/user'

export default {
  data() {
    return {
      // 分页
      pageParam: {
        index: 1,
        size: 10,
        total: 0,
      },
      // 数据
      userList: [],
      // 一键删除
      more: false, // 删除按钮显示状态
      select: [], // 选中的数据
      // 查询参数对象
      queryParam: {
        username: '',
        nickname: '',
        phone: '',
        sex: '',
        time: '',
      },
    }
  },
  methods: {
    // 提交查询
    submitSearch() {
      // 调用下面的查询方法
      this.findUserList()
    },
    // 清空查询参数
    clearForm(formName) {
      this.$refs[formName].resetFields()
    },
    // 每选中一个就会执行的方法
    handleSelectionChange(val) {
      if (val.length === 0) { 
        // 选中0个，隐藏按钮
        this.more = false
      } else {
        // 选中1个以上，显示一键删除按钮
        this.more = true
      }
      this.select = val
    },
    // 一键删除多个用户
    deleteMore() {
      this.$confirm('此操作将删除多个用户，是否继续？', '提示', {
        confirmButtonText: '确定',
        type: 'warning',
      }).then(() => {
        let ids = []
        // 取出用户ID
        this.select.forEach((item) => {
          ids.push(item.id)
        })
        // 调用删除多个用户的接口
        user.deleteMoreUser(ids).then((_) => {
          this.$notify({
            title: '删除成功',
            type: 'success',
          })
          this.findUserList()
        })
      })
    },
    // 切页
    handleCurrentChange(index) {
      this.pageParam.index = index
      this.findUserList()
    },
    // 查询用户列表
    findUserList() {
      user.findUserList(this.pageParam.index, this.pageParam.size, this.queryParam).then((res) => {
        this.userList = res.data.userList
        this.pageParam.total = res.data.total
      })
    },
    // 删除单个用户
    deleteUser(id) {
      this.$confirm('此操作将删除改用户, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }).then(() => {
        // 调用删除接口
        user.deleteUser(id).then((_) => {
          this.$message({
            type: 'success',
            message: '删除成功!',
          })
          this.findUserList()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除',
        })
      })
    },
  },
  created() {
    this.findUserList()
  },
}
</script>