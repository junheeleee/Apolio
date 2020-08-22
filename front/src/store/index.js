import Vue from 'vue'
import Vuex from 'vuex'
import pathify from 'vuex-pathify'
import * as modules from './modules'
import api from '../api'

Vue.use(Vuex)

export default new Vuex.Store({
  modules,

  state: {
    drawer: false,
    links: [
      'Home',
      'About me',
      'Portfolio',
      'Blog',
      'Community',
      'Contact',
      'Membership',
    ],
    thumbnails :[],
    Korea: [],
    USA: [],
    France: [],
    Singapore: [],
    Canada: [],
    UK: [],
    // posts: [],
  },
  mutations: {
    SET_DRAWER (state, payload) {
      state.drawer = payload
    },
    Korea(state, resp) {
      state.Korea = resp.data;
    },
    USA(state, resp) {
      state.USA = resp.data;
    },
    France(state, resp) {
      state.France = resp.data;
    },
    Singapore(state, resp) {
      state.Singapore = resp.data;
    },
    Canada(state, resp) {
      state.Canada = resp.data;
    },
    UK(state, resp) {
      state.UK = resp.data;
    },
    thumbnails(state, resp) {
      state.thumbnails = resp.data;
    }
  },
  
  actions : {
    async loadCrawling ({ state,commit }) {
      const resp1 = await api.Korea();
      commit("Korea", resp1);
      window.console.log(resp1)
      const resp2 = await api.USA();
      commit("USA", resp2);
      window.console.log(resp2)
      const resp3 = await api.France();
      commit("France", resp3);
      window.console.log(resp3)
      const resp4 = await api.Singapore();
      commit("Singapore", resp4);
      window.console.log(resp4)
      const resp5 = await api.Canada();
      commit("Canada", resp5);
      window.console.log(resp5)
      const resp6 = await api.UK();
      commit("UK", resp6);
      window.console.log(resp6)
      // state.thumbnails = [...state.Korea,...state.USA,...state.France,...state.Singapore,...state.Canada,...state.UK]
    },
      // inputData({state}){
        // state.thumbnails = [state.thumbnails,...state.Korea,...state.]
        // const Korea = state.Korea.map((Korea) => {
        //   const thumbnails = {}
        //   thumbnails.category = 'Korea'
        //   thumbnails.src = Korea.urltoimage
        //   return thumbnails
        // })
        // const USA = state.USA.map((USA) => {
        //   const thumbnails = {}
        //   thumbnails.category = 'USA'
        //   thumbnails.src = USA.urltoimage
        //   return thumbnails
        // })
        // const France = state.France.map((France) => {
        //   const thumbnails = {}
        //   thumbnails.category = 'France'
        //   thumbnails.src = France.urltoimage
        //   return thumbnails
        // })
        // const Singapore = state.Singapore.map((Singapore) => {
        //   const thumbnails = {}
        //   thumbnails.category = 'Singapore'
        //   thumbnails.src = Singapore.urltoimage
        //   return thumbnails
        // })
        // const Canada = state.Canada.map((Canada) => {
        //   const thumbnails = {}
        //   thumbnails.category = 'Canada'
        //   thumbnails.src = Canada.urltoimage
        //   return thumbnails
        // })
        // const UK = state.UK.map((UK) => {
        //   const thumbnails = {}
        //   thumbnails.category = 'UK'
        //   thumbnails.src = UK.urltoimage
        //   return thumbnails
        // })
        // state.thumbnails = [...state.thumbnails,...Korea,...USA,...France,...Singapore,...Canada,...UK]
  },
  
  plugins: [pathify.plugin],
})
