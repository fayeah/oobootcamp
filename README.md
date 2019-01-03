定义：
1. 上层模块不应该依赖底层模块，它们都应该依赖于抽象；
2. 抽象不应该依赖于细节，细节应该依赖于抽象；

a. 控制反转是设计模式，遵从了依赖倒置的原则；  
b. 依赖注入是实现控制反转的手段；

reference:
https://blog.csdn.net/briblue/article/details/75093382

ParkingLot Task:

Given: 停车场有空位  
When: 需要停车  
Then: 停车成功  

Given: 停车场没有空位  
When: 需要停车  
Then: 停车失败  

Given: 停车场有一辆我的车  
When: 需要取车  
Then: 取车成功  

Given: 停车场有一辆我的车  
When: 使用无效票取车  
Then: 取车失败  

Given: 停车场有一辆我的车  
When: 使用有效票取到两次  
Then: 取车失败  

Parkingboy task:

Given: 有一个停车场且有空位  
When: 需要parkingboy停车  
Then: 停车成功  

Given: 有两个停车场且都有空位  
When: 需要parkingboy停车  
Then: 成功停在第一个停车场  

Given: 有两个停车场且第一个满了，第二个有空位  
When: 需要parkingboy停车  
Then: 成功停在第二个停车场  

Given: 两个停车场都满了  
When: 需要parkingboy停车  
Then: 停车失败  

Given: 车在停车场，且有有效票  
When: 需要parkingboy取车  
Then: 成功取车  

Given: 车在停车场  
When: 用无效票取车  
Then: 取车失败  

SmartParkingBoy tasks:

Given: 有一个停车场且有空位   
When: 需要停车  
Then: 停车成功  

Given: 有两个停车场，两个停车场都有空位，且第一个空位多于第二个     
When: 需要停车  
Then: 成功停在第一个停车场  

Given: 有两个停车场，两个停车场都有空位，且第二个空位多于第一个     
When: 需要停车  
Then: 成功停在第二个停车场 

Given: 有两个停车场，两个停车场都有空位，且第二个空位等于第一个     
When: 需要停车  
Then: 成功停在第一个停车场    

Given: 有两个停车场，两个都满的         
When: 需要停车  
Then: 停车失败  

Given: 车在停车场，且有有效票  
When: 需要parkingboy取车  
Then: 成功取车  

Given: 车在停车场  
When: 用无效票取车  
Then: 取车失败  

parkingManager tasks:

Given: 停车小弟都没有报道，parking manager管理一个停车场
When: 需要停车  
Then: 停车成功

Given: 停车小弟都没有报道，parking manager管理两个停车场，都有空位
When: 需要停车  
Then: 停车成功，且停在第一个停车场

Given: formal停车小弟报道，管理1个停车场，且有空位  
When: 需要停车  
Then: 停车成功，且停在该停车场  

Given: formal停车小弟报道，管理1个停车场A，manager管理1个停车场B，且A满了，B有空位  
When: 需要停车  
Then: 停车成功，且停在停车场B

Given: smart停车小弟报道，管理1个停车场，且有空位  
When: 需要停车  
Then: 停车成功，且停在该停车场  

Given: formal停车小弟和smart停车小弟依次报道，formal管理停车场A，smart管理停车场B，且都有空位  
When: 需要停车  
Then: 停车成功，且停在停车场A

Given: smart停车小弟和formal停车小弟依次报道，formal管理停车场A，smart管理停车场B，且都有空位  
When: 需要停车  
Then: 停车成功，且停在停车场B  

Given: smart停车小弟和formal停车小弟依次报道，formal管理停车场A、B，smart管理停车场C、D，且都有空位  
When: 需要停车  
Then: 停车成功，且停在停车场C、D里空位最多的那一个  

Given: formal停车小弟和smart停车小弟依次报道，formal管理停车场A、B，smart管理停车场C、D，且都有空位  
When: 需要停车  
Then: 停车成功，且停在停车场A

Given: formal停车小弟和smart停车小弟依次报道，formal管理停车场A、B，smart管理停车场C、D，且只有C、D有空位  
When: 需要停车  
Then: 停车成功，且停在停车场C、D里空位最多的那一个  

Given: smart停车小弟和formal停车小弟依次报道，formal管理停车场A、B，smart管理停车场C、D，且只有A、B有空位  
When: 需要停车  
Then: 停车成功，且停在停车场A  

Given: smart停车小弟和formal停车小弟依次报道，formal管理停车场A、B，smart管理停车场C、D，manager管理E，A、B、C、D都满，E有空位  
When: 需要停车  
Then: 停车成功，且停在E  

Given: smart停车小弟和formal停车小弟依次报道，formal管理停车场A、B，smart管理停车场C、D，manager管理E，A、B、C、D、E都满  
When: 需要停车  
Then: 停车失败
  