<template>
  <v-container
    id="portfolio"
    class="pa-0"
    fluid
    tag="section"
  >
    <portfolio-hero
      class="text-center white--text align-center"
      height="30vh"
    >
      <h1 class="display-2">
        My Portfolio
      </h1>
    </portfolio-hero>
    
    <portfolio-headline />

    <gallery />
  </v-container>
</template>

<script>
  export default {
    name: 'Portfolio',

    components: {
      Gallery: () => import('@/components/base/Gallery'),
      PortfolioHero: () => import('@/components/base/PortfolioHero'),
      PortfolioHeadline: () => import('@/components/base/PortfolioHeadline'),
    },
  }
</script>
