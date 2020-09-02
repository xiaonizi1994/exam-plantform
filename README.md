### 问题
跨上下文如何优雅的通信？
例如上下文A的domain 要用到上下文B domain里面的数据。
查阅了书本推荐了Restful API通信，但是太过于繁琐了。需要从repository写到service 层，再写到controller。
跨上下文通信直接引要用的上下文的service，或者repository，是不是一种好方式？

