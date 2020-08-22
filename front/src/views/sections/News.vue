<template>
  <v-container
    id="news"
    tag="section"
  >
    <div>
      <div class="text-center">Click<br>↓</div>
      <div class="text-center">
        <v-btn
          icon
          @click="showTabs = !showTabs"
        >
          <v-icon>mdi-view-grid</v-icon>
        </v-btn>
      </div>
        <v-expand-transition>
          <v-tabs
            v-if="showTabs"
            v-model="filter"
            background-color="transparent"
            centered
            hide-slider
          >
            <v-tab
              v-for="(tab, i) in countries"
              :key="i"
              :href="`#${tab}`"
              @click="dataFilter"
            >
              {{ tab }}
            </v-tab>
          </v-tabs>
        </v-expand-transition>
    </div> 
    <!-- 필터 -->
   <v-responsive
      class="mx-auto"
      max-width="1280"
    >
      <v-container>
          <!-- posts -->
        <v-row>
          <v-col
            v-for="(post, i) in thumbnail"
            :key="i"
            class="d-flex"
            cols="12"
            md="4"
          >
          <v-card :post="post">
              <v-img
                :src="post.urltoimage"
                height="200"
              >
                <a :href="post.url">
                  <v-hover>
                    <template v-slot="{ hover }">
                      <v-overlay
                        :color="hover ? 'white' : 'black'"
                        absolute
                        class="align-end pa-3 justify-start"
                        opacity=".2"
                      >
                        <v-btn
                          color="#252525"
                          dark
                          small
                          v-if="!!post.author"
                        >
                          {{ post.author }}
                        </v-btn>
                      </v-overlay>
                    </template>
                  </v-hover>
                </a>
              </v-img>

              <div class="px-3 pb-4">
                <v-card-title
                  class="headline font-weight-bold mb-2"
                  v-text="post.title"
                />

                <v-card-text class="body-1 grey--text text-darken-2">
                  <div
                    class="mb-4"
                    v-text="post.publishedAt"
                  />

                  <div v-text="post.description" />
                </v-card-text>
              </div>
            </v-card>

          </v-col>
        </v-row>
      </v-container>
    </v-responsive>
  </v-container>
</template>

<script>
import axios from 'axios'
import { mapState,mapActions } from 'vuex'

const API_URL = 'http://i3c103.p.ssafy.io:4000'

export default {
  name: 'News',
  
  components: {
    // PostCard: () => import('@/components/base/BlogPostCard'),
  },
  data () {
      return {
      show: false,
      dialog: false,
      page: 1,
      filter: 'All',
      showTabs: false,
      thumbnail: null,
      countries : [
        'Korea',
        'USA',
        'France',
        'Singapore',
        'Canada',
        'UK',
      ],
      // posts: [
      //   {
      //     blurb: undefined,
      //     category: undefined,
      //     date: undefined,
      //     src: undefined,
      //     title: undefined,
      //   }
      // ]
      }
  },
  computed: {
    ...mapState(["Korea",'USA','France','Singapore','Canada','UK','posts']),
  },
  methods : {
    ...mapActions(['inputData','loadCrawling']),
    async createData(){
      await this.loadCrawling()
      // this.inputData()
      console.log(this.thumbnails)
    },
    dataFilter(){
      if (this.filter === 'Korea'){
        this.thumbnail = this.Korea
      } else if (this.filter === 'USA'){
        this.thumbnail = this.USA
      } else if (this.filter === 'France'){
        this.thumbnail = this.France
      } else if (this.filter === 'Singapore'){
        this.thumbnail = this.Singapore
      } else if (this.filter === 'Canada'){
        this.thumbnail = this.Canada
      } else if (this.filter === 'UK'){
        this.thumbnail = this.UK
      }
      console.log(this.filter)
      console.log(this.thumbnail)
        // console.log('여기에 들어왔습니까?')
        // this.thumbnail = this.thumbnails.map((item)=>{
        //   if (item.category === this.filter ){
        //     const a = {}
        //     a.category = item.category
        //     if (item.src === null) {
        //       a.src = "디폴트값입니다."
    
        //    } else { 
               
        //       a.src = item.src
        //     }
        //     return a
        //   }
        // })
        // this.thumbnail = this.thumbnail.filter(function(item){
        //   return !!item
        // })
      // }
    // console.log(this.thumbnail)
    },
  },
  mounted() {
    this.createData()
  },
}
</script>

<style lang="sass">
  .gallery
    // max-width: 1280px
</style>