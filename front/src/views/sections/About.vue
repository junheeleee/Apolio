<template>
  <v-container
    id="about"
    class="pa-0"
    fluid
    tag="section"
  >
    <v-row
      class="ma-0"
      no-gutters
    >
      <v-col
        cols="12"
        md="6"
      >
        <v-img
          height="calc(100vh - 96px - 156px)"
          src="@/assets/javert3.jpg"
        />
      </v-col>

      <v-col
        class="d-block d-md-flex align-center grey lighten-3 pa-6"
        cols="12"
        md="6"
      >
        <v-responsive
          class="mx-auto px-3 px-md-12"
          max-width="750"
        >
          <h1
            class="mb-6"
            :class="$vuetify.breakpoint.mdAndUp ? 'display-1' : 'display-1'"
          >
            Hello. This is javert.<br>
            I'm a Junior developer<br>
            who mainly studies front-end design.
          </h1>

          <p>
            SSAFY(삼성 청년 소프트웨어 아카데미)에서 개발하고 있는<br>
            주니어 프론트엔드 엔지니어 입니다.
          </p>

          <p>
            Language : Python, Java, Javascript, Korean, English, French<br>
            Back End: Django, Java Spring, AWS<br>
            Front End: HTML, CSS, Javascript, Vue, Vuetify
          </p>

          <div class="signature">
            jesuisjavert
          </div>
        </v-responsive>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    name: 'About',
  }
</script>

<style lang="sass">
  .signature
    font-family: 'Cedarville Cursive', cursive !important
    font-size: 2rem
    font-style: italic
</style>
