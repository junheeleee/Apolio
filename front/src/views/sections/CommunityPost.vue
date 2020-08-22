<template>
  <v-container
    id="CommunityPost"
    class="pa-0"
    fluid
    tag="section"
  >
    <blog-hero
      class="text-center white--text align-center"
      height="30vh"
    >
      <h1 class="display-2">
        jesuisjavert's Blog
      </h1>
    </blog-hero>
  </v-container>
</template>

<script>
  export default {
    name: 'CommunityPost',

    components: {
      BlogHero: () => import('@/components/base/BlogHero'),
    },
  }
</script>
