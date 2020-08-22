// Utilities
import { make } from 'vuex-pathify'

let image = 0
const categories = [
  'All',
  '운영체제',
  '소프트웨어공학',
  '자료구조',
  'Django',
  '알고리즘',
  '스프링',
  '클라우드',
]

const state = {
  categories,
  filter: 'All',
  picture: null,
  pictures: Array.from({ length: 30 }).map(() => {
    image++

    return {
      src: `images/pic/pic${image}.png`,
      category: categories[Math.floor(Math.random() * categories.length)],
    }
  }),
}

const mutations = make.mutations(state)

export default {
  namespaced: true,
  state,
  mutations,
}
