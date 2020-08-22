
<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'CommunityPost',

    metaInfo: { title: 'CommunityPost' },

    extends: View,

    mixins: [
      LoadSections([
        'CommunityPost',
      ]),
    ],

    props: {
      id: {
        type: String,
        default: 'CommunityPost',
      },
    },
  }
</script>
