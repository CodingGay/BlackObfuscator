# DEX控制流混淆 · BlackObfuscator

**[English Version](README_EN.md)**

![](https://img.shields.io/badge/language-java-brightgreen.svg)

本项目针对Android APK  DEX控制流混淆，在不会改变应用原有逻辑的前提下，会将原始代码进行控制流混淆，使得代码难以阅读，增加反编译阅读的难度以达到保护应用。

## 项目声明
- 本项目基于 [dex2jar](https://github.com/pxb1988/dex2jar) 进行修改
- Black系列交流群：390562046（QQ）

## 注意事项
- 本项目基于dex2jar，为了出现转换过程中避免不必要的问题，请尽量混淆自己业务的代码，避免其余三方库一起混淆，在混淆规则内提供自己的业务代码路径。

## Android Studio插件支持
目前本项目已集成Android Studio插件，支持打包自动化混淆。详情请移至：[BlackObfuscator-ASPlugin](https://github.com/CodingGay/BlackObfuscator-ASPlugin)

## GUI支持
GUI工具已开发完成，详情请移至：[BlackObfuscator-GUI](https://github.com/CodingGay/BlackObfuscator-GUI)

## 如何使用
### Main#main

参数 | 解释
---|---
-d | 混淆深度，越高混淆越深
-i | 输入dex的路径 
-o | 输出dex的路径 
-a | 规则文件，见下一步骤
-p | 需要进行混淆的包名

```java
    BlackObfuscatorCmd.main("d2j-black-obfuscator",
            "-d", "2",
            "-i", "/Users/milk/Documents/classes.dex",
            "-o", "/Users/milk/Documents/classes_out.dex",
            "-a", "filter.txt");
```
### 混淆规则
#### 提供需要混淆的类
```x
#it is annotation
#cn.kaicity

#class
cn.kaicity.gk.cdk.BuildConfig

#package
cn.kaicity

#blackList
!cn.kaicity.gk.cdk

#blackList中的包或者类不会进行混淆
```

## 后续计划
- 更高强度的混淆

## 效果展示
### 混淆前
![xx](image/orig.png)
### 混淆后
![xx](image/obf1.png)
![xx](image/obf2.png)

## 感谢
- [dex2jar](https://github.com/pxb1988/dex2jar)

## 请作者儿子喝奶粉
![xx](image/wechat.png)
![xx](image/aliplay.jpg)

### License

> ```
> Copyright 2021 Milk
>
> Licensed under the Apache License, Version 2.0 (the "License");
> you may not use this file except in compliance with the License.
> You may obtain a copy of the License at
>
>    http://www.apache.org/licenses/LICENSE-2.0
>
> Unless required by applicable law or agreed to in writing, software
> distributed under the License is distributed on an "AS IS" BASIS,
> WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
> See the License for the specific language governing permissions and
> limitations under the License.
> ```
