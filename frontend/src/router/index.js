import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/views/HelloWorld'
Vue.use(Router)

const LIstvue = () => import(/* webpackChunkName: "list" */ '@/views/LIstvue')
const BoardCrete = () => import(/* webpackChunkName: "bcrete" */ '@/views/BoardCreate')
const BoardDetail = () => import(/* webpackChunkName: "detail" */ '@/views/BardDetail')
const ImageView = () => import(/* webpackChunkName: "imgview" */ '@/views/ImageView')
const ImgEditor = () => import(/* webpackChunkName: "ImgEditor" */ '@/components/ImgEditor')

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/list',
      name: 'LIstvue',
      component: LIstvue
    },
    {
      path: '/bcrete',
      name: 'BoardCrete',
      component: BoardCrete
    },
    {
      path: '/detail/:boardNo',
      name: 'BoardDetail',
      component: BoardDetail
    },
    {
      path: '/imgview',
      name: 'ImageView',
      component: ImageView
    },
    {
      path: '/ImgEditor',
      name: 'ImgEditor',
      component: ImgEditor
    }
  ]
})
