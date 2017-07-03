import Ember from 'ember';

export default Ember.Route.extend({
  model() {
    return ['Martin Fowler', 'Uncle Bob'];
  }
});
