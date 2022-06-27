# Jnapitomysql
Java接入http接口存入mysql
Java接入Kafka消息存入mysql
#git与GitHub相关的
1.点开邮箱，找到github发送的邮件，加入组织
2.删除项目底下的 .git 文件
3.使用git工具 在项目底下 git init
4.添加git与自己GitHub的连接，由于已经加入了组织，所以提交到自己的组织就行
5.　  git add . 
　　   git commit -m "自己"
      git remote rm origin
      git remote add origin https://github.com/jinniuqu-organization/jnapitomysql.git
      git remote set-url origin https://你的GitHubSSH Key@github.com/jinniuqu-organization/jnapitomysql.git 
      #具体可以参考网址https://www.cnblogs.com/kermitjam/p/10697185.html
      git branch -M main
      git push  origin main
6.提交代码流程：
再idea里面选择git - commit -提交备注
在git.exe里面
先下载最新的文件
git pull
再上传
git push -u origin main
