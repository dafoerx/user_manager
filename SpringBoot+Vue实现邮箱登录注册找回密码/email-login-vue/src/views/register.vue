<template>
  <div class="register">
    <div class="register-form">
      <h2>注册</h2>

      <el-form :model="registerForm" :rules="rules" ref="registerForm" label-width="70px">

      <el-form-item label="邮箱" prop="email">
        <el-input prefix-icon="el-icon-message" placeholder="请填写邮箱" maxlength="32" v-model="registerForm.email" ></el-input>
      </el-form-item>

      <el-form-item label="密码" prop="password">
        <el-input prefix-icon="el-icon-lock" placeholder="请填写 6-18 位密码" type="password" maxlength="18" v-model="registerForm.password" show-password></el-input>
      </el-form-item>

      <el-form-item label="确认密码" prop="passwordConfirm">
        <el-input prefix-icon="el-icon-lock" placeholder="请填写 6-18 位密码" type="password" maxlength="18" v-model="registerForm.passwordConfirm" show-password></el-input>
      </el-form-item>

      <el-form-item label="验证码" prop="code">
        <el-input prefix-icon="el-icon-key" placeholder="请填写6位数字验证码" type="number" maxlength="6" v-model="registerForm.code">
          <el-button slot="append" @click="sendEmailCode()" :disabled="disabled">{{ msg }}</el-button>
        </el-input>
      </el-form-item>

      <el-form-item class="btn-r" label-width="0px">
        <el-button type="danger" icon="el-icon-s-promotion" :loading="loading" @click="submitForm('registerForm')">注 册</el-button>
      </el-form-item>

      <el-form-item class="btn-l" label-width="0px">
        <router-link to="/login">
        <el-button type="success" icon="el-icon-back">登 录</el-button></router-link>
      </el-form-item>

    </el-form>
    </div>
  </div>
</template>

<script>
import common from '@/api/common'
import user from '@/api/user'

export default {
    data() {
      var email = (rule, value, callback) => {
        if(!value) {
          return callback(new Error('请输入邮箱！'))
        }else if(!/^([a-zA-Z0-9]+[-_\.]?)+@[a-zA-Z0-9]+\.[a-z]+$/.test(value)) {
          return callback(new Error('请输入正确的邮箱！'))
        }else{
          return callback()
        }
      };
      var password = (rule, value, callback) => {
        if(!value) {
          return callback(new Error('请输入密码！'))
        }else if(!/(?=.*[a-zA-Z])[a-zA-Z0-9]{6,18}/.test(value)) {
          return callback(new Error("密码长度在6-18个字符，只能包含数字、大小写字母 且 至少包含一个字母！"))
        }else if(this.registerForm.passwordConfirm !== '') {
          this.$refs.registerForm.validateField('passwordConfirm');
          return callback()
        }else {
          return callback()
        }
      };
      var passwordConfirm = (rule, value, callback) => {
        if(!value) {
          return callback(new Error('请输入确认密码！'))
        }else if(!/(?=.*[a-zA-Z])[a-zA-Z0-9]{6,18}/.test(value)) {
          return callback(new Error("密码长度在6-18个字符，只能包含数字、大小写字母 且 至少包含一个字母！"))
        }else if(value !== this.registerForm.password) {
          return callback(new Error('两次输入的密码不一致！'))
        }else {
          return callback()
        }
      };
      var code = (rule, value, callback) => {
        if(!value) {
          return callback(new Error('请输入6位验证码！'))
        }else if(value.length !== 6) {
          return callback(new Error('请输入6位验证码！'))
        }else {
          return callback()
        }
      };
      return {
        registerForm: {
          email: '',
          password: '',
          passwordConfirm: '',
          code: ''
        },
        // 倒计时
        disabled: false,
        msg: '点击获取验证码',
        count: 60,
        timer: 0,
        // 按钮加载
        loading: false,
        rules: {
          email: [
            { validator: email, trigger: 'blur' }
          ],
          password: [
            { validator: password, trigger: 'blur' }
          ],
          passwordConfirm: [
            { validator: passwordConfirm, trigger: 'blur'}
          ],
          code: [
            { validator: code, trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      // 注册
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.loading = true
            user.register(this.registerForm).then(_ => {
              if(_) {
                // 注册成功
                setTimeout(() => {
                  this.$router.push({ path: '/index'})
                }, 500);

                this.$message({
                  message: '注册成功',
                  type: 'success'
                })
              }
            }).finally(_ => {
              this.loading = false
            })
          }
        });
      },
      // 获取验证码
      sendEmailCode() {
        this.$refs.registerForm.validateField('email', result => {
          if(!result) {
            // 按钮倒计时
            this.disabled = true;
            this.msg = this.count-- + 's后重新获取';
            this.timer = setInterval(() => {
              this.msg = this.count-- + 's后重新获取';
              if (this.count < 0) {
                this.msg = '点击获取验证码';
                this.count = 60;
                this.disabled = false;
                clearInterval(this.timer);
              }
            }, 1000);

            // 发送验证码请求
            common.getRequestCode(this.registerForm.email).then(_ => {
              common.getEmailCode(this.registerForm.email, _.data.permissionCode).then(_ => {
                if(_) {
                  // 通知邮箱发送
                  this.$notify({
                    title: '邮箱验证码已发送',
                      message: '验证码有效时长5分钟, 失效请重新发送',
                      type: 'success',
                      duration: 10 * 1000
                  })
                }
              })
            })
          }
        });
      },
    }
  }
</script>

<style>
.register {
  background-color: azure;
  height: 100%;

  display: flex;
  justify-content: center;
  align-items: center;
  background: url('../assets/login.jpg') fixed no-repeat;
  background-size: 100% 100%;
}

.register-form {
  height: 400px;
  width: 600px;
  box-sizing: border-box;
  background-color: #fff;
  opacity: 0.8;
  padding: 20px 50px;
}

.register-form input::-webkit-outer-spin-button,
.register-form input::-webkit-inner-spin-button {
	-webkit-appearance: none;
}

.register-form input[type='number'] {
	-moz-appearance: textfield;
}

.btn-r {
  width: 100px;
  float: right;
}

.btn-l {
  width: 100px;
  float: left;
}
</style>