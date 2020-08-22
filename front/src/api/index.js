import axios from 'axios'

export default {
  Korea() {
    return axios.get(`http://i3c103.p.ssafy.io:4000/api/news/korea`)
  },
  USA() {
    return axios.get(`http://i3c103.p.ssafy.io:4000/api/news/usa`)
  },
  France() {
    return axios.get(`http://i3c103.p.ssafy.io:4000/api/news/france`)
  },
  Singapore() {
    return axios.get(`http://i3c103.p.ssafy.io:4000/api/news/singapore`)
  },
  Canada() {
    return axios.get(`http://i3c103.p.ssafy.io:4000/api/news/canada`)
  },
  UK() {
    return axios.get(`http://i3c103.p.ssafy.io:4000/api/news/uk`)
  },
}