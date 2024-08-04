<p align="center">
    <img src=https://gw.alipayobjects.com/zos/k/fa/logo-modified.png width=138/>
</p>
<h1 align="center">Pake</h1>
<p align="center"><strong>利用 Rust 轻松构建轻量级多端桌面应用</strong></p>
<div align="center">
    <a href="https://twitter.com/HiTw93" target="_blank">
    <img alt="twitter" src="https://img.shields.io/badge/follow-Tw93-red?style=flat-square&logo=Twitter"></a>
    <a href="https://t.me/+GclQS9ZnxyI2ODQ1" target="_blank">
    <img alt="telegram" src="https://img.shields.io/badge/chat-telegram-blueviolet?style=flat-square&logo=Telegram"></a>
    <a href="https://github.com/tw93/Pake/releases" target="_blank">
    <img alt="GitHub downloads" src="https://img.shields.io/github/downloads/tw93/Pake/total.svg?style=flat-square"></a>
    <a href="https://github.com/tw93/Pake/commits" target="_blank">
    <img alt="GitHub commit" src="https://img.shields.io/github/commit-activity/m/tw93/Pake?style=flat-square"></a>
    <a href="https://github.com/tw93/Pake/issues?q=is%3Aissue+is%3Aclosed" target="_blank">
    <img alt="GitHub closed issues" src="https://img.shields.io/github/issues-closed/tw93/Pake.svg?style=flat-square"></a>
    <a href="https://colab.research.google.com/drive/1bX345znvDZ30848xjRtpgtU8eypWwXrp?usp=sharingg" target="_blank">
    <img alt="在 Colab 中打开" src="https://colab.research.google.com/assets/colab-badge.svg"></a>
</div>
<div align="left">支持 Mac / Windows / Linux，关于 <a href="#命令行一键打包">命令行一键打包</a>、<a href="#定制开发">定制开发</a> 可见下面文档，也欢迎去 <a href=https://github.com/tw93/Pake/discussions>讨论区</a> 交流。</div>

## 特征

- 🎐 相比传统的 Electron 套壳打包，要小将近 20 倍，5M 上下。
- 🚀 Pake 的底层使用的 Rust Tauri 框架，性能体验较 JS 框架要轻快不少，内存小很多。
- 📦 不是单纯打包，实现了快捷键的透传、沉浸式的窗口、拖动、样式改写、去广告、产品的极简风格定制。
- 👻 只是一个很简单的小玩具，用 Tauri 替代之前套壳网页打包的老思路，其实 PWA 也很好。


## 开始之前

1. **小白用户**：使用 「常用包下载」 方式来把玩 Pake 的能力，可去 [讨论群](https://github.com/tw93/Pake/discussions) 寻求帮助，也可试试 [Action](https://github.com/tw93/Pake/wiki/%E5%9C%A8%E7%BA%BF%E7%BC%96%E8%AF%91%EF%BC%88%E6%99%AE%E9%80%9A%E7%94%A8%E6%88%B7%E4%BD%BF%E7%94%A8%EF%BC%89) 方式。
2. **开发用户**：使用 「命令行一键打包」，对 Mac 比较友好，Windows / Linux 需折腾下 [环境配置](https://tauri.app/v1/guides/getting-started/prerequisites)。
3. **折腾用户**：假如你前端和 Rust 都会，那可试试下面的 「[定制开发](#定制开发)」，可深度二次开发定制你的功能。

## 命令行一键打包

<kbd>
  <img src="https://gw.alipayobjects.com/zos/k/zd/pake.gif" width="100%">
</kbd>
<br/><br/>

**Pake 提供了命令行工具，可以更快捷方便地一键自定义打你需要的包，详细可见 [文档](./bin/README_CN.md)。**

```bash
# 使用 npm 进行安装
npm install -g pake-cli

# 命令使用
pake url [OPTIONS]...

# 随便玩玩，首次由于安装环境会有些慢，后面就快了
pake https://weekly.tw93.fun --name Weekly --hide-title-bar
```

假如你不太会使用命令行，或许使用 **GitHub Actions 在线编译多系统版本** 是一个不错的选择，可查看 [文档](https://github.com/tw93/Pake/wiki/%E5%9C%A8%E7%BA%BF%E7%BC%96%E8%AF%91%EF%BC%88%E6%99%AE%E9%80%9A%E7%94%A8%E6%88%B7%E4%BD%BF%E7%94%A8%EF%BC%89)。

## 定制开发

开始前请确保电脑已经安装了 Rust `>=1.63` 和 Node `>=16 如 16.18.1` 的环境，此外需参考 [Tauri 文档](https://tauri.app/v1/guides/getting-started/prerequisites) 快速配置好环境才可以开始使用，假如你太不懂，使用上面的命令行打包会更加合适。

```sh
# 安装依赖
npm i

# 本地开发[右键可打开调试模式]
npm run dev

# 打包应用
npm run build

```

## 高级使用

1. 代码结构可参考 [文档](https://github.com/tw93/Pake/wiki/Pake-%E7%9A%84%E4%BB%A3%E7%A0%81%E7%BB%93%E6%9E%84%E8%AF%B4%E6%98%8E)，便于你在开发前了解更多。
2. 修改 src-tauri 目录下 `pake.json` 中的 `url` 和 `productName` 字段，需同步修改下 `tauri.config.json` 中的 `domain` 字段，以及 `tauri.xxx.conf.json` 中的 `icon` 和 `identifier` 字段，其中 `icon` 可以从 icons 目录选择一个，也可以去 [macOSicons](https://macosicons.com/#/) 下载符合效果的。
3. 关于窗口属性设置，可以在 `pake.json` 修改 windows 属性对应的 `width/height`，fullscreen 是否全屏，resizable 是否可以调整大小，假如想适配 Mac 沉浸式头部，可以将 hideTitleBar 设置成 `true`，找到 Header 元素加一个 padding-top 样式即可，不想适配改成 `false` 也行。
4. 此外样式改写、屏蔽广告、逻辑代码注入、容器消息通信、自定义快捷键可见 [高级用法](https://github.com/tw93/Pake/wiki/Pake-%E7%9A%84%E9%AB%98%E7%BA%A7%E7%94%A8%E6%B3%95)。
