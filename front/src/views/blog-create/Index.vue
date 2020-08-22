
<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'BlogCreate',

    metaInfo: { title: 'BlogCreate' },

    extends: View,

    mixins: [
      LoadSections([
        'BlogCreate',
      ]),
    ],

    props: {
      id: {
        type: String,
        default: 'BlogCreate',
      },
    },
  }
</script>
