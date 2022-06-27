# Jnapitomysql
Java接入http接口存入mysql
Java接入Kafka消息存入mysql
#git与GitHub相关的
1.点开邮箱，找到github发送的邮件，加入组织
2.删除项目底下的 .git 文件
3.使用git工具 在项目底下 git init
4.添加git与自己GitHub的连接，由于已经加入了组织，所以提交到自己的组织就行
5.　 git add . 
　　git commit -m "自己"
      git remote rm origin
      git remote add origin https://github.com/huantaixian/htapitomysql.git
      git remote set-url origin https://你的GitHubSSH Key@github.com/huantaixian/htapitomysql.git #具体可以参考网址https://www.cnblogs.com/kermitjam/p/10697185.html
      git branch -M main
      git push  origin main
6.提交完后下载先更新别人的代码 git pull 
 再先在git里面提交community 
 后面再git push  origin main