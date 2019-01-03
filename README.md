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
