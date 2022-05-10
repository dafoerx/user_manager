<template>
  <div class="app">
    <div class="form">
      <el-form :model="userList"
               :rules="rules"
               ref="userList"
               label-width="100px"
               class="demo-ruleForm">

        <el-form-item label="用户名"
                      prop="username">
          <el-input v-model="userList.username"></el-input>
        </el-form-item>

        <el-form-item label="昵称"
                      prop="nickname">
          <el-input v-model="userList.nickname"></el-input>
        </el-form-item>

        <el-form-item label="密码"
                      prop="password">
          <el-input v-model="userList.password"></el-input>
        </el-form-item>

        <el-form-item label="电话"
                      prop="phone">
          <el-input v-model="userList.phone"></el-input>
        </el-form-item>

        <el-form-item label="性别"
                      prop="sex">
          <el-select v-model="userList.sex"
                     placeholder="请选择活动区域">
            <el-option label="男"
                       value="0"></el-option>
            <el-option label="女"
                       value="1"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="描述"
                      prop="describe">
          <el-input type="textarea"
                    v-model="userList.describe"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary"
                     @click="submitForm('userList')">提交</el-button>
          <el-button @click="resetForm('userList')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import user from '../api/user'
export default {
  data() {
    return {
      status: false,
      userList: {
        username: '',
        nickname: '',
        password: '',
        phone: '',
        sex: '',
        describe: '',
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        nickname: [{ required: true, message: '请输入昵称', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
        phone: [{ required: true, message: '请输入电话', trigger: 'blur' }],
        sex: [{ required: true, message: '请选择性别', trigger: 'blur' }],
        describe: [{ required: true, message: '请输入描述', trigger: 'blur' }],
      },
    }
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if(this.status) {
            user.updateUser(this.userList).then(_ => {
              this.$router.push('/')
            })
          }else{
            user.addUser(this.userList).then((_) => {
              this.$router.push('/')
            })
          }
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    check() {
      if(this.$route.params && this.$route.params.id) {
        this.status = true
        user.getUserInfo(this.$route.params.id).then( res => {
          this.userList = res.data.user
        })
      }
    }
  },
  created() {
    this.check()
  },
  watch: {
    $route(to, from) {
      this.check()
    }
  }
}
</script>

<style>
.form {
  width: 50%;
}
</style>