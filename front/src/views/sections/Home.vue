<template>
  <v-container
    id="home"
    class="pt-12 pb-0 px-0"
    fluid
    tag="section"
  >
    <!-- <home-hero
      class="text-center white--text align-center"
      height="30vh"
    >
      <h1 class="display-2">
        jesuisjavert
      </h1> -->
    <!-- <home-hero> -->

    <home-headline />
    
  </v-container>
</template>

<script>
  export default {
    name: 'Home',

    components: {
      HomeHero : () => import('@/components/base/HomeHero'),
      HomeHeadline: () => import('@/components/base/HomeHeadline'),
    },
  }
</script>
