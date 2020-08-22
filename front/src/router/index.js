import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      component: () => import('@/components/core/Index.vue'),
      children: [
        {
          path: '',
          name: 'Home',
          component: () => import('@/views/home/Index.vue'),
        },
        {
          path: '/about',
          name: 'About me',
          component: () => import('@/views/about/Index.vue'),
        },
        {
          path: '/portfolio',
          name: 'Portfolio',
          component: () => import('@/views/portfolio/Index.vue'),
        },
        {
          path: '/blog',
          name: 'Blog',
          component: () => import('@/views/blog/Index.vue'),
        },
        {
          path: '/blog-post',
          name: 'Blog Post',
          component: () => import('@/views/blog-post/Index.vue'),
        },
        {
          path: '/blog/create',
          name: 'BlogCreate',
          component: () => import('@/views/blog-create/Index.vue'),
        },
        {
          path: '/community',
          name: 'Community',
          component: () => import('@/views/community/Index.vue'),
        },
        {
          path: '/community-post',
          name: 'Community Post',
          component: () => import('@/views/community-post/Index.vue'),
        },
        {
          path: '/contact',
          name: 'Contact',
          component: () => import('@/views/contact/Index.vue'),
        },
        {
          path: '/membership',
          name: 'Membership',
          component: () => import('@/views/membership/Index.vue'),
        },
        {
          path: '/Mypage',
          name: 'Mypage',
          component: () => import('@/views/mypage/Index.vue'),
        },
        {
          path: '/oauth2/redirect',
          name: 'Oauth',
          component: () => import('@/views/oauth/Index.vue'),
        },
      ],
    },
  ],
})
