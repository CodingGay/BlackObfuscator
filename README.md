# DEX控制流混淆 · BlackObfuscator

![](https://img.shields.io/badge/language-java-brightgreen.svg)

本项目针对Android APK  DEX控制流混淆，在不会改变应用原有逻辑的前提下，会将原始代码进行控制流混淆，使得代码难以阅读，增加反编译阅读的难度以达到保护应用。

## 项目声明
- 本项目基于 [dex2jar](https://github.com/pxb1988/dex2jar) 进行修改
- 目前是基础最简单的混淆版本，测试稳定性为主，后续将持续更新升级。

## 注意事项
- 本项目基于dex2jar，为了出现转换过程中避免不必要的问题，请最好将需要混淆的类提取成一个单独的dex再进行混淆，避免各种三方库等转换。

## 后续计划
- 支持 android studio，打包自动化混淆
- 更高强度的混淆

## 效果展示
### 混淆前
![xx](image/orig.png)
### 混淆后
![xx](image/obf1.png)
![xx](image/obf2.png)

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
