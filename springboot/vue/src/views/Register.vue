<template>
  <div class="wrapper">
    <div style="margin: 100px auto; background-color: #fff; width: 350px; height: 400px; padding: 20px; border-radius: 10px">
      <div style="margin: 20px 0; text-align: center; font-size: 24px">註 冊</div>
      <el-form :model="user" :rules="rules" ref="userForm">
        <el-form-item prop="username">
          <el-input placeholder="請輸入帳號" size="medium" style="margin: 5px 0" prefix-icon="el-icon-user" v-model="user.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="請輸入密碼" size="medium" style="margin: 5px 0" prefix-icon="el-icon-lock" show-password v-model="user.password"></el-input>
        </el-form-item>
        <el-form-item prop="confirmPassword">
          <el-input placeholder="請確認密碼" size="medium" style="margin: 5px 0" prefix-icon="el-icon-lock" show-password v-model="user.confirmPassword"></el-input>
        </el-form-item>
        <el-form-item style="margin: 10px 0; text-align: right">
          <el-button type="primary" size="small" autocomplete="off" @click="login">註冊</el-button>
          <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/login')">返回登錄</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data(){
    return{
      user:{},
      rules: {
        username: [
          {required: true, message: '請輸入使用者名稱', trigger: 'blur'},
          {min: 3, max: 10, message: '使用者名稱長度為 3 到 10 個英文或數字', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '請輸入密碼', trigger: 'blur'},
          {min: 3, max: 10, message: '密碼長度為 3 到 10 個英文或數字', trigger: 'blur'}
        ],
        confirmPassword: [
          {required: true, message: '請輸入密碼', trigger: 'blur'},
          {min: 3, max: 10, message: '密碼長度為 3 到 10 個英文或數字', trigger: 'blur'}
        ],
      }
    }
  },
  methods:{
    login(){
      this.$refs['userForm'].validate((valid) => {
        if (valid) { // 表單檢驗成功
          if(this.user.password !== this.user.confirmPassword){
            this.$message.error("兩次密碼輸入不一致")
            return false
          }
          this.request.post("/managers/register", this.user).then(res =>{
            if(!res){
              this.$message.error("使用者名稱或密碼錯誤")
            }else{
              this.$message.success("註冊成功")
              this.$router.push('/login')
            }
          })
        }
      });
    }
  }
}
</script>

<style>
.wrapper{
  height: 100vh;
  background-image: Linear-gradient(to bottom right, #FC466B, #3F5EFB);
  overflow: hidden;
}
</style>