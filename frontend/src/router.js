
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import MarketingRetargettingManager from "./components/listers/MarketingRetargettingCards"
import MarketingRetargettingDetail from "./components/listers/MarketingRetargettingDetail"

import UserUserManager from "./components/listers/UserUserCards"
import UserUserDetail from "./components/listers/UserUserDetail"

import SalesStatusView from "./components/SalesStatusView"
import SalesStatusViewDetail from "./components/SalesStatusViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/marketings/retargettings',
                name: 'MarketingRetargettingManager',
                component: MarketingRetargettingManager
            },
            {
                path: '/marketings/retargettings/:id',
                name: 'MarketingRetargettingDetail',
                component: MarketingRetargettingDetail
            },

            {
                path: '/users/users',
                name: 'UserUserManager',
                component: UserUserManager
            },
            {
                path: '/users/users/:id',
                name: 'UserUserDetail',
                component: UserUserDetail
            },

            {
                path: '/users/salesStatuses',
                name: 'SalesStatusView',
                component: SalesStatusView
            },
            {
                path: '/users/salesStatuses/:id',
                name: 'SalesStatusViewDetail',
                component: SalesStatusViewDetail
            },


    ]
})
