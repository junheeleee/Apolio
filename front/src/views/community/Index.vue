
<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'Community',

    metaInfo: { title: 'Community' },

    extends: View,

    mixins: [
      LoadSections([
        'Community',
      ]),
    ],

    props: {
      id: {
        type: String,
        default: 'community',
      },
    },
  }
</script>
