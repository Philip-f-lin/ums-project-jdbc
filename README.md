# 個人專案 - 使用者管理系統
採 SpringBoot + Vue 前後端分離的開發模式，此系統提供使用者註冊、登錄，以及增、刪、改、查，等功能。 

# 使用技術
• 前端使用 Vue 框架，採 Element UI 套件  

• 使用 axios 與後端 RESTful API 串接  

• 後端採 Controller 、 Service 、 Dao 三層式架構設計，透過 Spring JDBC 訪問 MySQL 資料庫

# 快速上手
1、運行環境和所需工具

• 編譯器：IntelliJ IDEA 2023.2.1  

• 項目構建工具：Maven 

• 資料庫：MySQL  

• JDK 版本：jdk11   

2、初始化項目  

• 下載 project 並使用 IntelliJ 開啟  

• 在你的 MySQL 資料庫中，創建一個名稱為 project 的資料庫，並導入 user table 

• 修改 spring boot 中的 application.yml 配置文件，把 username 和 password 改為自己的  

• 安裝最新版本的 Node.js 和 npm  

# 功能介紹

啟動 Vue  

npm run serve  

運行 SpringbootApplication  

接著輸入 'http://localhost:8085/' 進入到使用者管理頁面    

# 1. 查詢
• 可以透過帳號、信箱、地址查詢  
• 若沒有輸入，則全部查詢
<img width="1352" alt="271995120-36101373-c7b8-4fe7-afa3-0bcfc62f4994" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/7426ecdc-a0f6-431e-a221-5b4b1198df02">
<img width="1353" alt="271995134-a85431ae-5a26-4d1d-b56a-5aa967145361" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/f2b19e11-af00-4c32-b361-9da3258be96e">



# 2. 刪除  
• 單個刪除  
• 透過多選框進行多個刪除  
<img width="1355" alt="271992233-1d96817d-2079-4c9c-aa74-c5673917b5bf" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/2019d6b2-abe5-4ed5-b145-c53cb12ba7e9">
<img width="1354" alt="271992252-b1139c9d-b1be-4992-90f5-8c3ef5dc713e" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/b68053f9-7ce2-4ce3-8193-c9db0027635e">
<img width="1354" alt="271992553-8b1dcf38-57da-4d8b-8ae3-81e9157757ab" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/3df58d77-0d67-45db-9c8a-6f4b396eb26c">
<img width="1352" alt="271992374-dac830d1-4c2f-4e05-994f-7da9216893a8" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/f6a6db72-70ce-4039-89b9-26a3c360d13b">


# 3. 修改
• 點擊編輯後，會顯示可以修改的資訊  
• 修改完成後，在頁面顯示修改成功及展示修改內容  
<img width="1351" alt="271993817-74bf93b6-0a57-456f-8830-1f20389d69f8" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/93824c35-821d-41df-af5a-eb9802ffa53a">
<img width="1352" alt="271993826-73512587-ff0b-4059-be6d-33f9f34cddb4" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/a684cfdc-2a64-494a-ad19-2769fdb986a1">
<img width="1352" alt="271993838-80702725-1554-48eb-9873-85db0b3526d3" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/b2973e6f-0069-425f-93a7-79f64a1493a5">

# 4. 新增
• 點擊新增後，並輸入資訊，即可在頁面展示  
<img width="1355" alt="271990600-1c3dd8ad-75d2-4874-b014-19a77aa6ba20" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/37b4e9cb-2970-4985-a19c-0f1ca2b2180b">
<img width="1351" alt="271990622-beaf89d5-5517-44ff-a6a6-bb22fe5bde65" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/a94959e1-eb54-4aa0-ba30-5fe01b9a30dd">
<img width="1353" alt="271990647-244a4455-be4a-45f3-8132-9e7093955700" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/6b71c720-9f16-41fd-93c0-307a36cfc4e0">


# 5. 註冊畫面
<img width="1426" alt="截圖 2023-10-16 下午9 49 44" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/56d75c8a-3b14-4599-844d-e6cd075f28c7">

# 6. 登錄畫面
<img width="1429" alt="截圖 2023-10-16 下午9 49 28" src="https://github.com/Philip-f-lin/ums-project-jdbc/assets/133033495/b8a5874b-eee1-48a7-b866-8a596dae98e5">







